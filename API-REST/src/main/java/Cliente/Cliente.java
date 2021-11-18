package Cliente;
import javax.persistence.*;

// Un modelo sirve para mapear la clase, es decir, Spring plasmará la clase con sus atributos como una tabla en la BBDD.

//En este paquete tenemos nuestro clase Cliente.java y utilizaremos las @anotaciones JPA para relacionarla con nuestra tabla clientes.
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @Column(name="codigo")
    private String codigo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;

    public Cliente(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
    }
}