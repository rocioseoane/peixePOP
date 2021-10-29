package peixepop;

import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class Estanque {
    
    public final int maxTiburones = 6;
    
    private String codigo;
    private String nombre;
    private String tipo;
    private ArrayList<Tiburon> tiburones;

    public Estanque(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tiburones = new ArrayList<Tiburon>();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tiburon> getTiburones() {
        return tiburones;
    }

    public void setTiburon(Tiburon tiburon) {
        this.tiburones.add(tiburon);
    }

}
