package peixepop;

import java.util.ArrayList;

/**
 * Clase para crear un objeto tipo Estanque
 * @author Angel, Jose, Miguel, Paulo
 */
public class Estanque {
    
    // Maximo de tiburones por estanque
    public final int maxTiburones = 6;
    
    // Código de la sala
    private String codigo;
    
    // Nombre de la sala
    private String nombre;
    
    // Tipo de la sala
    private String tipo;
    
    // Tiburones que tiene cada estanque
    private ArrayList<Tiburon> tiburones;

    /**
     * Constructor por defecto
     * @param codigo Identificador único de cada estanque
     * @param nombre Nombre de cada estanque
     * @param tipo En que está especializada el estanque
     */
    public Estanque(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tiburones = new ArrayList<Tiburon>();
    }

    /**
     * @return String Devuélve el tipo de la sala
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo Se le asigna un tipo a la sala
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return String Devuélve el código de la sala
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Se le asigna un código a la sala
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String Devuélve el nombre de la sala
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Se le asigna un nombre a la sala
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return ArrayList Devuélve un arraylist con los tiburones del estanque
     */
    public ArrayList<Tiburon> getTiburones() {
        return tiburones;
    }

    /**
     * @param tiburon Se le añade un tiburon al estanque
     */
    public void agregarTiburones(Tiburon tiburon) {
        this.tiburones.add(tiburon);
    }

}
