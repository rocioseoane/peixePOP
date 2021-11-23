package App.Evento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "requisito_edad")
    private Integer requisito_edad;

    @Column(name = "aforo")
    private Integer aforo;

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getRequisito_edad() {
        return requisito_edad;
    }

    public void setRequisito_edad(Integer requisito_edad) {
        this.requisito_edad = requisito_edad;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo() {
        this.codigo = codigo;
    }
}
