package co.com.brayanscompany.appanalizatest.dao;

import co.com.brayanscompany.appanalizatest.modelo.ImprimirModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import co.com.brayanscompany.appanalizatest.modelo.RegistroModel;
import co.com.brayanscompany.appanalizatest.modelo.RespuestasModel;
import co.com.brayanscompany.appanalizatest.vista.Index;
import co.com.brayanscompany.appanalizatest.vista.PresentacionPrueba;
import co.com.brayanscompany.appanalizatest.vista.Resultados;
import co.com.brayanscompany.appanalizatest.vista.SelPrueba;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * @author Brayan
 */
public class RegistroDAO {

    private final Connection con;
    private Integer id;

    public RegistroDAO(Connection con) {
        this.con = con;

    }

    public boolean registrar(RegistroModel model) {
        if (validarNumero(model.getNumero())) {
            JOptionPane.showMessageDialog(
                    null,
                    "El número de identificación ya está registrado.");
            return false;
        }

        if (validarCorreo(model.getCorreo())) {
            JOptionPane.showMessageDialog(
                    null,
                    "El correo electrónico ya está registrado.");
            return false;
        }

        try {
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "INSERT INTO registro "
                    + "(prinombre, segnombre, priapellido, segapellido, tipoID, ID, correo, contrasena, confirmado)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setString(1, model.getPriNombre());
                statement.setString(2, model.getSegNombre());
                statement.setString(3, model.getPriApellido());
                statement.setString(4, model.getSegApellido());
                statement.setString(5, model.getTipo());
                statement.setString(6, model.getNumero());
                statement.setString(7, model.getCorreo());
                statement.setString(8, model.getPassword());
                statement.setString(9, model.getConpassword());

                statement.execute();
                JOptionPane.showMessageDialog(
                        null,
                        "Registro Éxitoso.");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERROR" + e);
        }
        return true;
    }

    public boolean iniciar(RegistroModel model) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT prinombre, priapellido, ID, contrasena FROM registro WHERE correo=?");

            statement.setString(1, model.getCorreo());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String contrasenaRegistrada = resultSet.getString("contrasena");

                    if (contrasenaRegistrada.equals(model.getPassword())) {
                        String primerNombre = resultSet.getString("prinombre");
                        String primerApellido = resultSet.getString("priapellido");
                        String numero = resultSet.getString("ID");
                        almaDatos(primerNombre, primerApellido, numero);
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Contraseña incorrecta. Por favor, inténtelo de nuevo.");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "No se encontró ningún registro con el correo proporcionado.");
                    return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return true;
    }

    public boolean selePrueba(RegistroModel model) {
        if (validarPrueba(model.getPrueba(), model.getNumero())) {
            JOptionPane.showMessageDialog(
                    null,
                    "El usuario ya seleccionó esta prueba anteriormente.");
            return false;
        }
        try {
            PreparedStatement insertStatement = con.prepareStatement(
                    "INSERT INTO selprueba (nomprueba, id_usuario, dia, mes, año) VALUES (?, ?, ?, ?, ?)");

            insertStatement.setString(1, model.getPrueba());
            insertStatement.setString(2, model.getNumero());
            insertStatement.setString(3, model.getDia());
            insertStatement.setString(4, model.getMes());
            insertStatement.setString(5, model.getAnnio());
            datosPrueba(model.getPrueba(), model.getNumero());
            insertStatement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al insertar en la tabla selprueba: " + e.getMessage());
        }
        return true;
    }

    public boolean datosPrueba(String tipo, String numero) {
        switch (tipo) {
            case "Ciencias Naturales":
                id = 1;
                break;
            case "Estudios Sociales":
                id = 6;
                break;
            case "Inglés":
                id = 11;
                break;
            case "Lectura Crítica":
                id = 16;
                break;
            case "Matemáticas":
                id = 21;
                break;
            default:
                throw new AssertionError();
        }
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT enunciado, opcA, opcB, opcC, opcD FROM prueba WHERE tipo = ? AND id = ?");
            statement.setString(1, tipo);
            statement.setInt(2, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String en = resultSet.getString("enunciado");
                    String opcA = resultSet.getString("opcA");
                    String opcB = resultSet.getString("opcB");
                    String opcC = resultSet.getString("opcC");
                    String opcD = resultSet.getString("opcD");
                    PresentacionPrueba prueba = new PresentacionPrueba();
                    prueba.setTipoText(tipo);
                    prueba.setEnunText(en);
                    prueba.setOpcAText(opcA);
                    prueba.setOpcBText(opcB);
                    prueba.setOpcCText(opcC);
                    prueba.setOpcDText(opcD);
                    prueba.setNumeroText(numero);
                    prueba.setIdPruebaText(id);
                    prueba.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error en el envio:");
                    return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al enviar la prueba: " + e);
            return false;
        }
        return true;
    }

    public boolean siguientePregunta(RespuestasModel model) {
        if (validarPregunta(model.getNumero(), model.getTipo(), 1 + model.getId())) {
        }

        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT enunciado, opcA, opcB, opcC, opcD FROM prueba WHERE tipo = ? AND id = ?");
            statement.setString(1, model.getTipo());
            statement.setInt(2, 1 + model.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String en = resultSet.getString("enunciado");
                    String opcA = resultSet.getString("opcA");
                    String opcB = resultSet.getString("opcB");
                    String opcC = resultSet.getString("opcC");
                    String opcD = resultSet.getString("opcD");
                    PresentacionPrueba prueba = new PresentacionPrueba();
                    prueba.setTipoText(model.getTipo());
                    prueba.setEnunText(en);
                    prueba.setOpcAText(opcA);
                    prueba.setOpcBText(opcB);
                    prueba.setOpcCText(opcC);
                    prueba.setOpcDText(opcD);
                    prueba.setNumeroText(model.getNumero());
                    prueba.setIdPruebaText(1 + model.getId());
                    prueba.setVisible(true);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al enviar la prueba: " + e);
            return false;
        }
        return true;

    }

    public boolean validarRespuestasYComparar(String numero, String tipo) {
        int respuestasCorrectasCount = 0;
        int totalRespuestas = 0;

        try {
            PreparedStatement respuestaStatement = con.prepareStatement(
                    "SELECT respuesta FROM respuestas_usuario WHERE id_usuario = ? AND tipo = ?");
            respuestaStatement.setString(1, numero);
            respuestaStatement.setString(2, tipo);
            ResultSet respuestaResultSet = respuestaStatement.executeQuery();

            PreparedStatement correctaStatement = con.prepareStatement(
                    "SELECT opcionCorrecta FROM prueba WHERE tipo = ?");
            correctaStatement.setString(1, tipo);
            ResultSet correctaResultSet = correctaStatement.executeQuery();

            while (respuestaResultSet.next() && correctaResultSet.next()) {
                totalRespuestas++;
                String respuestasUsuario = respuestaResultSet.getString("respuesta");
                String respuestasCorrectas = correctaResultSet.getString("opcionCorrecta");

                String[] respuestasUsuarioArray = respuestasUsuario.split(",");
                String[] respuestasCorrectasArray = respuestasCorrectas.split(",");

                Arrays.sort(respuestasUsuarioArray);
                Arrays.sort(respuestasCorrectasArray);

                if (Arrays.equals(respuestasUsuarioArray, respuestasCorrectasArray)) {
                    respuestasCorrectasCount++;
                }
                System.out.println(Arrays.toString(respuestasUsuarioArray));

            }

            JOptionPane.showMessageDialog(null, "Respuestas correctas: " + respuestasCorrectasCount);
            JOptionPane.showMessageDialog(null, "Total de respuestas: " + totalRespuestas);

            if (respuestasCorrectasCount >= 5) {
                guardarResultados(respuestasCorrectasCount, "Aprobado", tipo, numero);
            } else {
                guardarResultados(respuestasCorrectasCount, "Perdido", tipo, numero);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA BÚSQUEDA DE LAS RESPUESTAS" + e);
        }
        return true;
    }

    public boolean guardarResultados(Integer cantidad, String estado, String tipo, String numero) {
        try {
            PreparedStatement insertStatement = con.prepareStatement(
                    "INSERT INTO resultados (cantidad, estado, prueba, id_usuario) VALUES (?, ?, ?, ?)");

            insertStatement.setInt(1, cantidad);
            insertStatement.setString(2, estado);
            insertStatement.setString(3, tipo);
            insertStatement.setString(4, numero);
            insertStatement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al insertar los resultados: " + e.getMessage());
        }
        return true;
    }

    public boolean validarPregunta(String numero, String tipo, Integer id) {
        if ("Ciencias Naturales".equals(tipo) && id == 6) {

            Index index = new Index();
            index.setVisible(true);
            validarRespuestasYComparar(numero, tipo);
        } else if ("Estudios Sociales".equals(tipo) && id == 11) {

            Index index = new Index();
            index.setVisible(true);
            validarRespuestasYComparar(numero, tipo);
        } else if ("Inglés".equals(tipo) && id == 16) {

            Index index = new Index();
            index.setVisible(true);
            validarRespuestasYComparar(numero, tipo);
        } else if ("Lectura Crítica".equals(tipo) && id == 21) {

            Index index = new Index();
            index.setVisible(true);
            validarRespuestasYComparar(numero, tipo);
        } else if ("Matemáticas".equals(tipo) && id == 26) {

            Index index = new Index();
            index.setVisible(true);
            validarRespuestasYComparar(numero, tipo);
        }
        return false;
    }

    public boolean validarPrueba(String tipPrueba, String num) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT nomprueba FROM selprueba WHERE nomprueba = ? AND id_usuario = ?");
            statement.setString(1, tipPrueba);
            statement.setString(2, num);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al validar la selección de prueba: " + e);
        }
        return false;
    }

    public boolean almaDatos(String nombre, String apellido, String numero) {
        SelPrueba selPrueba = new SelPrueba();
        selPrueba.setNombreText(nombre);
        selPrueba.setApellidoText(apellido);
        selPrueba.setNumeroText(numero);
        selPrueba.setVisible(true);
        return true;
    }

    private boolean validarNumero(String numero) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT ID FROM registro WHERE ID = ?");
            statement.setString(1, numero);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error en la validación de número de identificación: " + e);
        }
        return false;
    }

    private boolean validarCorreo(String correo) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT correo FROM registro WHERE correo = ?");
            statement.setString(1, correo);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error en la validación de correo electrónico: " + e);
        }
        return false;
    }

    public boolean registroRespuesta(RespuestasModel model) {
        try {
            int tiempoTotalSegundos = model.getTiempo();
            int minutos = tiempoTotalSegundos / 60;
            int segundos = tiempoTotalSegundos % 60;

            String tiempoFormateado = String.format("%02d:%02d:%02d", 0, minutos, segundos);
            PreparedStatement insertStatement = con.prepareStatement(
                    "INSERT INTO respuestas_usuario (id_usuario, respuesta, tipo, tiempo, id_prueba) VALUES (?, ?, ?, ?, ?)");

            insertStatement.setString(1, model.getNumero());
            insertStatement.setString(2, model.getRespuestaUsu());
            insertStatement.setString(3, model.getTipo());
            insertStatement.setString(4, tiempoFormateado);
            insertStatement.setInt(5, model.getId());

            insertStatement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al insertar en la tabla de respuestas: " + e.getMessage());
        }
        return true;
    }

    public boolean validarSel(String numero) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT nomprueba FROM selprueba WHERE id_usuario = ?");
            statement.setString(1, numero);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error en la validación de selección de prueba: " + e);
        }
        return true;
    }

    public boolean buscarDatos(RegistroModel model) {
        if (!validarNumero(model.getNumero())) {
            JOptionPane.showMessageDialog(null, "El número no se encuentra registrado.");
            return false;
        }

        if (!validarSel(model.getNumero())) {
            JOptionPane.showMessageDialog(null, "El usuario no ha seleccionado ninguna prueba.");
            return false;
        }

        try {
            String sqlRegistro = "SELECT prinombre, priapellido FROM registro WHERE ID = ?";
            PreparedStatement registro = con.prepareStatement(sqlRegistro);
            registro.setString(1, model.getNumero());
            ResultSet registroSet = registro.executeQuery();

            if (registroSet.next()) {
                String nombre = registroSet.getString("prinombre");
                String apellido = registroSet.getString("priapellido");
                int[] cantidades = obtenerCantidades(model.getNumero(), con);

                Resultados resultados = new Resultados();
                resultados.setNombreText(nombre);
                resultados.setApellidoText(apellido);
                resultados.setDatos(cantidades[0], cantidades[1], cantidades[2], cantidades[3], cantidades[4]);
                resultados.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR en las selecciones.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA BUSQUEDA: " + e);
        }

        return true;
    }

    private int[] obtenerCantidades(String numero, Connection con) {
        String[] pruebas = {"Ciencias Naturales", "Estudios Sociales", "Inglés", "Lectura Crítica", "Matemáticas"};
        int[] cantidades = new int[pruebas.length];

        for (int i = 0; i < pruebas.length; i++) {
            try {
                String sql = "SELECT cantidad FROM resultados WHERE id_usuario = ? AND prueba = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, numero);
                stmt.setString(2, pruebas[i]);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    cantidades[i] = resultSet.getInt("cantidad");
                } else {
                    JOptionPane.showMessageDialog(null, "No has presentado la prueba de " + pruebas[i]);
                    cantidades[i] = 0;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener resultados: " + e);
            }
        }

        return cantidades;
    }

    public boolean imprimir(ImprimirModelo modelo) {
        try {
            String ruta = System.getProperty("user.home");
            String archivoPDF = ruta + "/OneDrive/Escritorio/Resultados.pdf";
            Document documento = new Document(new Rectangle(792, 612));
            PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));
            documento.open();

            agregarResultados(documento, modelo);
            agregarUsuario(documento, modelo);

            documento.close();

            JOptionPane.showMessageDialog(null, "IMPRESIÓN LISTA, DIRÍGETE A ESCRITORIO.");
            return true;
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el PDF: " + e.getMessage());
        }
        return false;
    }

    private void agregarResultados(Document document, ImprimirModelo modelo) throws DocumentException {
        Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.ORANGE);
        Paragraph titulo = new Paragraph();
        Font fontEnunciado = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph enunciado = new Paragraph();
        Font fontEjem = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.ORANGE);
        Paragraph ejemplo = new Paragraph();
        Font fontNegrita1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph negrita1 = new Paragraph();
        Font fontEnunciado2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph enunciado2 = new Paragraph();
        Font fontNegrita2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph negrita2 = new Paragraph();
        Font fontEnunciado3 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph enunciado3 = new Paragraph();
        Font fontSubt = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph subtitulo = new Paragraph();
        Font fontEnunciado4 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph enunciado4 = new Paragraph();
        titulo.setFont(fontTitulo);
        enunciado.setFont(fontEnunciado);
        ejemplo.setFont(fontEjem);
        negrita1.setFont(fontNegrita1);
        enunciado2.setFont(fontEnunciado2);
        subtitulo.setFont(fontSubt);
        negrita2.setFont(fontNegrita2);
        enunciado3.setFont(fontEnunciado3);
        enunciado4.setFont(fontEnunciado4);
        titulo.add("¿Cómo entender mis resultados?\n\n");
        enunciado.add("El puntaje global es un promedio ponderado, esto quiere decir que cada\n");
        enunciado.add("prueba tiene un peso o valor diferente.\n");
        enunciado.add("Para este caso, Inglés tiene una ponderación de uno (1) y las demás pruebas\n");
        enunciado.add("(Lectura Crítica, Matemáticas, Estudios Sociales y Ciencias Natutales)\n");
        enunciado.add("una ponderación de tres (3).\n\n");

        ejemplo.add("Ejemplo:\n\n");

        negrita1.add("Paso 1:\n");
        enunciado2.add("Multiplicar el puntaje de cada prueba por su ponderación.\n\n");
        subtitulo.add("Prueba          Puntaje         Ponderación         Resultado\n\n");

        try {
            PreparedStatement statement = con.prepareStatement("SELECT ID, contrasena FROM registro WHERE correo = ?");
            statement.setString(1, modelo.getCorreo());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String contrasenaRegistrada = resultSet.getString("contrasena");
                    if (contrasenaRegistrada.equals(modelo.getContrasena())) {
                        String numero = resultSet.getString("ID");
                        String[] pruebas = {"Ciencias Naturales", "Estudios Sociales", "Inglés", "Lectura Crítica", "Matemáticas"};
                        int[] cantidades = new int[pruebas.length];

                        for (int i = 0; i < pruebas.length; i++) {
                            try {
                                String sql = "SELECT cantidad FROM resultados WHERE id_usuario = ? AND prueba = ?";
                                PreparedStatement resultados = con.prepareStatement(sql);
                                resultados.setString(1, numero);
                                resultados.setString(2, pruebas[i]);
                                ResultSet resultadosSet = resultados.executeQuery();

                                if (resultadosSet.next()) {
                                    cantidades[i] = resultadosSet.getInt("cantidad");
                                } else {
                                    cantidades[i] = 0;
                                }

                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Error al obtener resultados: " + e);
                            }
                        }
                        int c = cantidades[0];
                        int e = cantidades[1];
                        int in = cantidades[2];
                        int l = cantidades[3];
                        int m = cantidades[4];
                        int punC = (100 * c) / 5;
                        int punE = (100 * e) / 5;
                        int punI = (100 * in) / 5;
                        int punL = (100 * l) / 5;
                        int punM = (100 * m) / 5;
                        int resC = punC * 3;
                        int resE = punE * 3;
                        int resI = punI * 1;
                        int resL = punL * 3;
                        int resM = punM * 3;
                        enunciado3.add("Ciencias \n");
                        enunciado3.add("Naturales           " + punC + "        x             3              =         " + resC + "\n");
                        enunciado3.add("Estudios \n");
                        enunciado3.add("Sociales             " + punE + "        x             3              =        " + resE + "\n");
                        enunciado3.add("Inglés                 " + punI + "        x             1              =           " + resI + "\n");
                        enunciado3.add("Lectura \n");
                        enunciado3.add("Crítica                 " + punL + "      x             3              =          " + resL + "\n");
                        enunciado3.add("Matemáticas       " + punM + "      x              3              =         " + resM + "\n\n");
                        int rTemp = (resC + resE + resI + resL + resM) / 13;
                        negrita2.add("Paso 2: \n");
                        enunciado4.add("Sumar los resultados anteriores y dividir entre 13. Luego \n");
                        enunciado4.add("multiplicar por los (5) y aproximar al entero más cercano.\n\n");
                        enunciado4.add("    " + resC + "    +   " + resE + "    +    " + resI + "    +   " + resL + "    +   " + resM + "\n");
                        enunciado4.add("-------------------------------------------------------- =  " + rTemp + "\n");
                        enunciado4.add("                                    13\n\n");
                        int rTota = rTemp * 5;
                        enunciado4.add(rTemp + "        x       5       =       " + rTota + "       ¡TU PUNTUACIÓN TOTAL!\n\n");
                    } else {
                        mostrarMensaje("Contraseña incorrecta. Por favor, inténtelo de nuevo.");
                    }
                } else {
                    mostrarMensaje("No se encontró ningún registro con el correo proporcionado.");
                }
            }
        } catch (SQLException e) {
            mostrarMensaje("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        document.add(titulo);
        document.add(enunciado);
        document.add(ejemplo);
        document.add(negrita1);
        document.add(enunciado2);
        document.add(subtitulo);
        document.add(enunciado3);
        document.add(negrita2);
        document.add(enunciado4);

    }

    private void agregarUsuario(Document documento, ImprimirModelo modelo) throws DocumentException {
        Font fontEnunciados = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph enunciados = new Paragraph();
        enunciados.setFont(fontEnunciados);

        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM registro WHERE correo = ?");
            statement.setString(1, modelo.getCorreo());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String contrasenaRegistrada = resultSet.getString("contrasena");
                    if (contrasenaRegistrada.equals(modelo.getContrasena())) {
                        // Agregar enunciados con datos del usuario
                        enunciados.add("Primer Nombre: " + resultSet.getString(1) + "\n");
                        enunciados.add("Segundo Nombre: " + resultSet.getString(2) + "\n");
                        enunciados.add("Primer Apellido: " + resultSet.getString(3) + "\n");
                        enunciados.add("Segundo Apellido: " + resultSet.getString(4) + "\n");
                        enunciados.add("Tipo de ID: " + resultSet.getString(5) + "\n");
                        enunciados.add("ID: " + resultSet.getString(6) + "\n");
                        enunciados.add("Correo: " + resultSet.getString(7) + "\n");
                    } else {
                        mostrarMensaje("Contraseña incorrecta. Por favor, inténtelo de nuevo.");
                    }
                } else {
                    mostrarMensaje("No se encontró ningún registro con el correo proporcionado.");
                }
            }
        } catch (SQLException e) {
            mostrarMensaje("Error al ejecutar la consulta SQL: " + e.getMessage());
        }

        documento.add(enunciados);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
