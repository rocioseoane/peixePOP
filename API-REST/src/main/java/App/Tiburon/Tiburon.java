package App.Tiburon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiburones")
public class Tiburon {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "tamano", length = 10)
    private String tamano;

    @Column(name = "codigo_estanque", length = 12)
    private String codigo_estanque;

    public String getCodigo_estanque() {
        return codigo_estanque;
    }

    public void setCodigo_estanque(String codigo_estanque) {
        this.codigo_estanque = codigo_estanque;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
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
