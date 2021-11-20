package App.Estanque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estanques")
public class Estanque {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "codigo_sala", length = 12)
    private String codigo_sala;

    public String getCodigo_sala() {
        return codigo_sala;
    }

    public void setCodigo_sala(String codigo_sala) {
        this.codigo_sala = codigo_sala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
