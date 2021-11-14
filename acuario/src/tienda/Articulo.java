package tienda;

/**
 *
 * @author emilio
 */
public abstract class Articulo {

    private String codigo;
    private String descripcion;    
    private int stock;
    private double precio;
    
    public Articulo(String codigo, String descripcion, int stock, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock=stock;
        this.precio=precio;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
