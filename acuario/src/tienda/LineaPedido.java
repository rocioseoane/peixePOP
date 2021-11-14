package tienda;

public class LineaPedido {

    private int cantidad;
    private String codigo;
    private double precio;

    public LineaPedido(String codigo, int cantidad, double precio) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
   
}
