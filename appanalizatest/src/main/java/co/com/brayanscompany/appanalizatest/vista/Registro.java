package co.com.brayanscompany.appanalizatest.vista;

import co.com.brayanscompany.appanalizatest.controlador.RegistroController;

import co.com.brayanscompany.appanalizatest.modelo.RegistroModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author BRAYAN
 */
public class Registro extends javax.swing.JFrame {

    private final RegistroController registroController;

    /**
     * Creates new form registro
     */
    public Registro() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.OCULTAR.setVisible(false);
        this.OCULTAR1.setVisible(false);
        this.registroController = new RegistroController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        prinombre = new javax.swing.JTextField();
        segnombre = new javax.swing.JTextField();
        priape = new javax.swing.JTextField();
        segape = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        conpassword = new javax.swing.JPasswordField();
        VER = new javax.swing.JLabel();
        OCULTAR = new javax.swing.JLabel();
        VER1 = new javax.swing.JLabel();
        OCULTAR1 = new javax.swing.JLabel();
        company = new javax.swing.JLabel();
        derechos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        numero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        jLabel1.setText("REGISTRO");

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel2.setText("Primer Nombre*:");

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel3.setText("Segundo Nombre:");

        jLabel4.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel4.setText("Primer Apellido*:");

        jLabel5.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel5.setText("Segundo Apellido:");

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel6.setText("Correo*:");

        jLabel7.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel7.setText("Contraseña*:");

        jLabel8.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel8.setText("Confirmar Contraseña*:");

        btnregistrar.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        btnregistrar.setText("REGISTRAR");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnvolver.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        btnvolver.setText("VOLVER");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        prinombre.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        prinombre.setText("Primer Nombre");
        prinombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prinombreMousePressed(evt);
            }
        });

        segnombre.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        segnombre.setText("Segundo Nombre");
        segnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                segnombreMousePressed(evt);
            }
        });

        priape.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        priape.setText("Primer Apellido");
        priape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                priapeMousePressed(evt);
            }
        });

        segape.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        segape.setText("Segundo Apellido");
        segape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                segapeMousePressed(evt);
            }
        });

        correo.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        correo.setText("Correo Electronico");
        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                correoMousePressed(evt);
            }
        });

        password.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N

        conpassword.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N

        VER.setIcon(new javax.swing.ImageIcon("C:\\Users\\BRAYAN\\OneDrive\\Documents\\NetBeansProjects\\appanalizatest\\src\\main\\java\\resources\\images\\view.png")); // NOI18N
        VER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VERMouseClicked(evt);
            }
        });

        OCULTAR.setIcon(new javax.swing.ImageIcon("C:\\Users\\BRAYAN\\OneDrive\\Documents\\NetBeansProjects\\appanalizatest\\src\\main\\java\\resources\\images\\hide.png")); // NOI18N
        OCULTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OCULTARMouseClicked(evt);
            }
        });

        VER1.setIcon(new javax.swing.ImageIcon("C:\\Users\\BRAYAN\\OneDrive\\Documents\\NetBeansProjects\\appanalizatest\\src\\main\\java\\resources\\images\\view.png")); // NOI18N
        VER1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VER1MouseClicked(evt);
            }
        });

        OCULTAR1.setIcon(new javax.swing.ImageIcon("C:\\Users\\BRAYAN\\OneDrive\\Documents\\NetBeansProjects\\appanalizatest\\src\\main\\java\\resources\\images\\hide.png")); // NOI18N
        OCULTAR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OCULTAR1MouseClicked(evt);
            }
        });

        company.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        company.setText("© 2023 Brayan's Company.");

        derechos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        derechos.setText("Todos los derechos reservados.");

        jLabel9.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel9.setText("Tipo de identificación*:");

        jLabel10.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel10.setText("Número de identificación*:");

        tipo.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(seleccione)", "Tarjeta de Identidad", "Cédula de Ciudadanía", "Pasaporte", "Cédula Extranjera" }));

        numero.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        numero.setText("Número");
        numero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                numeroMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnvolver)
                        .addGap(40, 40, 40)
                        .addComponent(btnregistrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numero)
                            .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prinombre)
                            .addComponent(segape, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(priape)
                            .addComponent(segnombre))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(derechos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(company)
                                .addGap(13, 13, 13)))
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(VER1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OCULTAR1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(VER)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OCULTAR))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prinombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(segnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(segape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(OCULTAR, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(VER))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VER1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OCULTAR1))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolver)
                    .addComponent(btnregistrar))
                .addGap(18, 18, 18)
                .addComponent(company)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(derechos)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        if (prinombre.getText().isEmpty()  || priape.getText().isEmpty() ||
                tipo.getSelectedItem().equals("(seleccione)") ||
                numero.getText().isEmpty() || correo.getText().isEmpty() ||
                password.getText().isEmpty() ||conpassword.getText().isEmpty()||
                segnombre.getText().equals("Segundo Nombre")||
                segape.getText().equals("Segundo Apellido")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debes llenar los campos que son obligatorios.");
        } else {
            validacion();
            limpiar();
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Index index = new Index();
        index.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void VERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VERMouseClicked
        VER.setVisible(false);
        OCULTAR.setVisible(true);
        password.setEchoChar((char) 0);
    }//GEN-LAST:event_VERMouseClicked

    private void VER1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VER1MouseClicked
        VER1.setVisible(false);
        OCULTAR1.setVisible(true);
        conpassword.setEchoChar((char) 0);
    }//GEN-LAST:event_VER1MouseClicked

    private void OCULTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OCULTARMouseClicked
        VER.setVisible(true);
        OCULTAR.setVisible(false);
        password.setEchoChar('•');
    }//GEN-LAST:event_OCULTARMouseClicked

    private void OCULTAR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OCULTAR1MouseClicked
        VER1.setVisible(true);
        OCULTAR1.setVisible(false);
        conpassword.setEchoChar('•');
    }//GEN-LAST:event_OCULTAR1MouseClicked

    private void prinombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prinombreMousePressed
        prinombre.setText("");
    }//GEN-LAST:event_prinombreMousePressed

    private void segnombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_segnombreMousePressed
        segnombre.setText("");
    }//GEN-LAST:event_segnombreMousePressed

    private void priapeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priapeMousePressed
        priape.setText("");
    }//GEN-LAST:event_priapeMousePressed

    private void segapeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_segapeMousePressed
        segape.setText("");
    }//GEN-LAST:event_segapeMousePressed

    private void correoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMousePressed
        correo.setText("");
    }//GEN-LAST:event_correoMousePressed

    private void numeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroMousePressed
        numero.setText("");
    }//GEN-LAST:event_numeroMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OCULTAR;
    private javax.swing.JLabel OCULTAR1;
    private javax.swing.JLabel VER;
    private javax.swing.JLabel VER1;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel company;
    private javax.swing.JPasswordField conpassword;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel derechos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numero;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField priape;
    private javax.swing.JTextField prinombre;
    private javax.swing.JTextField segape;
    private javax.swing.JTextField segnombre;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables

    public boolean validacion() {
        String priNombre = prinombre.getText().trim();
        String segNombre = segnombre.getText().trim();
        String priApelli = priape.getText().trim();
        String segApelli = segape.getText().trim();
        String tipoID = tipo.getSelectedItem().toString();
        String ID = numero.getText().trim();
        String email = correo.getText().trim();
        String contrasena = password.getText();
        String confcontrasena = conpassword.getText();

        boolean contraseñaValida = validacionPassword();
        boolean correoValido = validacionCorreo();

        if (contraseñaValida && correoValido) {
            var registro = new RegistroModel(
                    priNombre,
                    segNombre,
                    priApelli,
                    segApelli,
                    tipoID,
                    ID,
                    email,
                    contrasena,
                    confcontrasena);
            this.registroController.guardar(registro);
            return true;
        }
        return false;
    }

    public boolean validacionPassword() {
        String contrasena = password.getText();
        String confcontrasena = conpassword.getText();

        if (contrasena.equals(confcontrasena)) {
            if (contrasena.length() >= 8) {
                boolean mayuscula = false;
                boolean numero = false;
                char c;
                for (int i = 0; i < contrasena.length(); i++) {
                    c = contrasena.charAt(i);
                    if (Character.isDigit(c)) {
                        numero = true;
                    }
                    if (Character.isUpperCase(c)) {
                        mayuscula = true;
                    }
                }
                if (mayuscula && numero) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "La contraseña debe tener un número y/o una mayúscula.");
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Las contraseña debe tener mínimo 8 caracteres.");
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Las contaseñas deben coincidir");
        }
        return false;
    }

    public boolean validacionCorreo() {
        String email = correo.getText().trim();
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Correo no válido.");
            return false;
        }
    }

    public void limpiar() {
        prinombre.setText("");
        segnombre.setText("");
        priape.setText("");
        segape.setText("");
        tipo.setSelectedIndex(0);
        numero.setText("");
        correo.setText("");
        password.setText("");
        conpassword.setText("");
    }
}