/*
 * 
 */
package tienda;

public abstract class Persona {

    //atributos
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;

    //constructor
    public Persona(String codigo, String nombre, String direcccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direcccion;
        this.telefono = telefono;
        this.codigo = codigo;
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecccion() {
        return direccion;
    }

    public void setDirecccion(String direcccion) {
        this.direccion = direcccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
