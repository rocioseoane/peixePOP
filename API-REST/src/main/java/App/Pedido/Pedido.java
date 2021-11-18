package App.Pedido;
import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "fecha")
    private Time fecha;

    @Column(name = "recibido")
    private Integer recibido;

    public Integer getRecibido() {
        return recibido;
    }

    public void setRecibido(Integer recibido) {
        this.recibido = recibido;
    }

    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
