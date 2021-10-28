/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class Estanque {
    
    public final int maxTiburonesGrandes = 1;
    public final int maxTiburonesMedianos = 2;
    public final int maxTiburonesPequenos = 3;
    public final int maxPlantas = 2;
    
    private String codigo;
    private String nombre;
    private String tipo;
    private Planta planta;
    private ArrayList<Tiburon> tiburones;

    public Estanque(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tiburones = new ArrayList<Tiburon>();
        this.planta = null;
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

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
    
    public void anadirPeces(){
        
    }
}
