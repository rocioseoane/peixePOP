package App.Articulo;
import javax.persistence.*;

@Entity
@Table(name="articulos")
public class Articulo {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "descripcion", length = 60)
    private String descripcion;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "tipo_articulo")
    private Integer tipo_articulo;

    public Integer getTipo_articulo() {
        return tipo_articulo;
    }

    public void setTipo_articulo(Integer tipo_articulo) {
        this.tipo_articulo = tipo_articulo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
