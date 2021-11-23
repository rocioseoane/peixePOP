package App.LineaFactura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lineas_facturas")
public class LineaFactura {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "codigo_factura")
    private Integer codigo_factura;

    public Integer getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(Integer codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
