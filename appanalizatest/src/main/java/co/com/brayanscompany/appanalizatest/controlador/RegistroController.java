package co.com.brayanscompany.appanalizatest.controlador;

import co.com.brayanscompany.appanalizatest.factory.ConnectionFactory;
import co.com.brayanscompany.appanalizatest.dao.RegistroDAO;
import co.com.brayanscompany.appanalizatest.modelo.ImprimirModelo;
import co.com.brayanscompany.appanalizatest.modelo.RegistroModel;
import co.com.brayanscompany.appanalizatest.modelo.RespuestasModel;
import javax.swing.JOptionPane;

/**
 * @author Brayan
 */
public class RegistroController {

    private final RegistroDAO registroDAO;

    public RegistroController() {
        var factory = new ConnectionFactory();
        this.registroDAO = new RegistroDAO(factory.recuperaConexion());
    }

    public boolean guardar(RegistroModel registroModel) {
        return registroDAO.registrar(registroModel);
    }

    public boolean iniciar(RegistroModel registroModel) {
        if (registroModel.getCorreo().isEmpty()
                || registroModel.getPassword().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debes llenar los campos.");
            return false;
        }
        return registroDAO.iniciar(registroModel);
    }

    public boolean selPruebba(RegistroModel registroModel) {
        return registroDAO.selePrueba(registroModel);
    }
    
    public boolean sigPregunta(RespuestasModel respuestasModel){
        return registroDAO.siguientePregunta(respuestasModel);
    }

    public boolean regisRespuesta(RespuestasModel respuestasModel) {
        return registroDAO.registroRespuesta(respuestasModel);
    }
    
    public boolean buscarResultados(RegistroModel registroModel){
        return registroDAO.buscarDatos(registroModel);
    }
    
    public boolean imprimirResultados(ImprimirModelo imprimirModelo){
        return registroDAO.imprimir(imprimirModelo);
    }
}
