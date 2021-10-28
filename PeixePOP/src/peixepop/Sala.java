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
    
    public final int maxEstanques = 2;
    
    private String codigo;
    private String tipo;
    private String nombre;
    private ArrayList<Estanque> estanques;

    public Sala(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estanques = new ArrayList<Estanque>();
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

    public ArrayList<Estanque> getEstanques() {
        return estanques;
    }

    public void setEstanques(Estanque estanque) {
        this.estanques.add(estanque);
    }
    
    /**
     * Itera entre los estanques y elimina el que corresponda con el ID
     * @param id Introducimos el ID del estanque a eliminar 
     * @return boolean
     */
    public boolean eliminarEstanque(String id) {
        for (Estanque estanque : estanques) {
            if(estanque.getCodigo().equals(id)) {
                estanques.remove(estanque);
                return true;
            }
        }
        return false;
    }
    
}
