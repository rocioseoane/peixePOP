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
public class Sala {
    
    private String codigo;
    private String nombre;
    private Planta planta;
    private ArrayList<Estanque> estanques;

    public Sala(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estanques = new ArrayList<Estanque>();
        this.planta = null;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
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

    public ArrayList<Estanque> getEstanques() {
        return estanques;
    }

    public void setPiscinas(ArrayList<Estanque> estanques) {
        this.estanques = estanques;
    }
    
}
