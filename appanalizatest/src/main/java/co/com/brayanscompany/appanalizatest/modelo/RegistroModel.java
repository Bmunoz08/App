package co.com.brayanscompany.appanalizatest.modelo;

/**
 *
 * @author BRAYAN
 */
public class RegistroModel {

    private String priNombre;
    private String segNombre;
    private String priApellido;
    private String segApellido;
    private String tipo;
    private String numero;
    private String correo;
    private String password;
    private String conpassword;
    private String prueba;
    private String dia;
    private String mes;
    private String annio;


    public RegistroModel(String priNombre, String segNombre, String priApellido,
                         String segApellido, String tipo, String numero, 
                         String correo, String password, String conpassword) {
        this.priNombre = priNombre;
        this.segNombre = segNombre;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.tipo = tipo;
        this.numero = numero;
        this.correo = correo;
        this.password = password;
        this.conpassword = conpassword;
    }
    
    public RegistroModel(String correo, String password){
        this.correo = correo;
        this.password = password;
    }
    
    public RegistroModel(String priNombre, String priApellido, String numero){
        this.priNombre = priNombre;
        this.priApellido = priApellido;
        this.numero = numero;
    }
    
    public RegistroModel(String prueba, String numero, String dia, String mes, String annio){
        this.prueba = prueba;
        this.numero = numero;
        this.dia = dia;
        this.mes = mes;
        this.annio = annio;
    }
    
    public RegistroModel(String numero){
        this.numero = numero;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public String getPriNombre() {
        return priNombre;
    }

    public void setPriNombre(String priNombre) {
        this.priNombre = priNombre;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

}
