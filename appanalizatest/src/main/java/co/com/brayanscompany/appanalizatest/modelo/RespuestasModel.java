package co.com.brayanscompany.appanalizatest.modelo;

/**
 *
 * @author BRAYAN
 */
public class RespuestasModel {

    private String respuestaUsu;
    private String numero;
    private String tipo;
    private Integer tiempo;
    private Integer id;

    public RespuestasModel(String numero, String respuestaUsu, String tipo, Integer tiempo, Integer id) {
        this.numero = numero;
        this.respuestaUsu = respuestaUsu;
        this.tipo = tipo;
        this.tiempo = tiempo;
        this.id = id;
    }
    
    public RespuestasModel(String numero, String tipo, Integer id){
        this.numero = numero;
        this.tipo = tipo;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespuestaUsu() {
        return respuestaUsu;
    }

    public void setRespuestaUsu(String respuestaUsu) {
        this.respuestaUsu = respuestaUsu;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
}
