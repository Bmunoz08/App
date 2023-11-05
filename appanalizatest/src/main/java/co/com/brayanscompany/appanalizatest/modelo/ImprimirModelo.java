package co.com.brayanscompany.appanalizatest.modelo;

/**
 *
 * @author BRAYAN
 */
public class ImprimirModelo {

    private String correo;
    private String contrasena;

    public ImprimirModelo(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
