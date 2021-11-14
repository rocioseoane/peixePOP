package tienda;
import java.util.Date;
import java.util.ArrayList;

public class Pedido {

    private String codigo;
    private Date fecha;
    private boolean recibido;
    private final ArrayList<LineaPedido> listaLineasPedido;

    public Pedido(String codigo, Date fecha, boolean recibido) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        LineaPedido lp = new LineaPedido(a.getCodigo(), cantidad, a.getPrecio());
        System.out.println("Artículo: " + a.getDescripcion());
        System.out.println("Cantidad: " + cantidad);
        listaLineasPedido.add(lp);
    }

    //lso siguientes metodos no se usarán en este MPV pero los hemos dejado implementados
    public void quitarLinea(LineaPedido linea) {
        for (LineaPedido l : listaLineasPedido) {
            if (l.getCodigo().equals(linea.getCodigo())) {
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
