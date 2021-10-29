package peixepop;

/**
 * Clase para crear un objeto tipo Tiburón
 * @author Angel, Jose, Miguel, Paulo
 */
public class Tiburon {
    
    // Tamaño del tiburón
    private String tamano;
    
    // Código de la sala
    private String codigo;
    
    // Nombre de la sala
    private String nombre;
    
    public Tiburon(String tamano, String codigo, String nombre) {
        this.tamano = tamano;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    /**
     * @return String Devuélve el código de la sala
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Se le asigna un código a la sala
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String Devuélve el nombre de la sala
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Se le asigna un nombre a la sala
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String Devuélve el tamaño del tiburón
     */
    public String getTamano() {
        return tamano;
    }
    
    /**
     * @param tamano Se le asigna un tamaño al tiburón
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
}
