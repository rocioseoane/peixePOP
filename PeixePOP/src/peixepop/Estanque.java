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
    
    private String codigo;
    private String nombre;
    private Planta planta;
    private ArrayList<Pez> peces;

    public Estanque(String codigo, String nombre, Planta planta, ArrayList<Pez> peces) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peces = new ArrayList<Pez>();
        this.planta = null;
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

    public ArrayList<Pez> getPeces() {
        return peces;
    }

    public void setPeces(ArrayList<Pez> peces) {
        this.peces = peces;
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
