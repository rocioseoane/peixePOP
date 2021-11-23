package App.Entrada;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "entradas")
public class Entrada {
    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "codigo_evento", length = 12)
    private String codigo_evento;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "codigo_cliente", length = 12)
    private String codigo_cliente;

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_evento() {
        return codigo_evento;
    }

    public void setCodigo_evento(String codigo_evento) {
        this.codigo_evento = codigo_evento;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}