package common;

/**
 *
 * @author emilio
 */
public abstract class Especie {
    
    private String codigo;
    private String descripcion;
    
    public Especie(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    /**
     * @return String Devuélve codigo de especie
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Asigna un codigo a la especie
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String Devuelve la descripcion de la especie
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Asigna una descripcion a la especie
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
