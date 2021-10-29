package peixepop;

/**
 *
 * @author Paulo
 */
public class Tiburon {
    
    private String tamano;
    public String codigo;
    private String nombre;
    private Estanque estanque;

    public Tiburon(String tamano, String codigo, String nombre) {
        this.tamano = tamano;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estanque = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
}
