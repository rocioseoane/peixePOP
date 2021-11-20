package App.LineaPedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lineas_pedidos")
public class LineaPedido {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "codigo_articulo", length = 12)
    private String codigo_articulo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "codigo_pedido")
    private Integer codigo_pedido;

    public Integer getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(Integer codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
