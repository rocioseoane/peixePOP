package App.Cliente;
import javax.persistence.*;

// Un modelo sirve para mapear la clase, es decir, Spring plasmará la clase con sus atributos como una tabla en la BBDD.
//En este paquete tenemos nuestro clase Cliente.java y utilizaremos las @anotaciones JPA para relacionarla con nuestra tabla clientes.
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @Column(name = "codigo", nullable = false, length = 12)
    private String codigo;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "telefono", length = 12)
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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