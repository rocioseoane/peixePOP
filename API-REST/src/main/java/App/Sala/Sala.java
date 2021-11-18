package App.Sala;
import javax.persistence.*;

@Entity
@Table(name="salas")
public class Sala {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "tipo", length = 50)
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
