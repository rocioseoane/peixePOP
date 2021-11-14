package tienda;
import java.util.ArrayList;

public class Pedido {

    private String codigo;
    private String fecha;
    private boolean recibido;
    private ArrayList<LineaPedido> listaLineasPedido;

    public Pedido(String codigo, String fecha, boolean recibido) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.recibido = recibido;
        this.listaLineasPedido = new ArrayList();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getRecibido() {
        return recibido;
    }

    public void setRecibido(boolean recibido) {
        this.recibido = recibido;
    }

    /**
     * @param a objeto artículo
     * @param cantidad del artículo que la hemos generado con Math.random() para
     * este MPV Crea un objeto LineaPedido con la cantidad, el código y el
     * precio de cada artículo y la añade al arrayList de lineas de pedido
     */
    public void añadirLinea(Articulo a, int cantidad) {
        LineaPedido lp = new LineaPedido(a, cantidad, a.getPrecio());
        System.out.println("Artículo: " + a.getDescripcion());
        System.out.println("Cantidad: " + cantidad);
        listaLineasPedido.add(lp);
    }

    //lso siguientes metodos no se usarán en este MPV pero los hemos dejado implementados
    public void quitarLinea(LineaPedido linea) {
        for (LineaPedido l : listaLineasPedido) {
            if (l.getArticulo().equals(linea.getArticulo())) {
                listaLineasPedido.remove(l);
            }
        }
    }

    public void enviar() {
        System.out.println("Pedido enviado");
    }

    public void recibir(boolean recibido) {
        System.out.println("Pedido recibido");
        recibido = true;
    }
}
