package App.Planta;
import javax.persistence.*;

@Entity
@Table(name="plantas")
public class Planta {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "medio_de_vida", length = 10)
    private String medio_de_vida;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "codigo_estanque", length = 12)
    private String codigo_estanque;

    @Column(name = "codigo_sala", length = 12)
    private String codigo_sala;

    public String getCodigo_sala() {
        return codigo_sala;
    }

    public void setCodigo_sala(String codigo_sala) {
        this.codigo_sala = codigo_sala;
    }

    public String getCodigo_estanque() {
        return codigo_estanque;
    }

    public void setCodigo_estanque(String codigo_estanque) {
        this.codigo_estanque = codigo_estanque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedio_de_vida() {
        return medio_de_vida;
    }

    public void setMedio_de_vida(String medio_de_vida) {
        this.medio_de_vida = medio_de_vida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
