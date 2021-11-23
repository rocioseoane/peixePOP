package App.Factura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "codigo_cliente", length = 12)
    private String codigo_cliente;

    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "importe_total")
    private Float importe_total;

    @Column(name = "pagada")
    private Integer pagada;

    public Integer getPagada() {
        return pagada;
    }

    public void setPagada(Integer pagada) {
        this.pagada = pagada;
    }

    public Float getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Float importe_total) {
        this.importe_total = importe_total;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
