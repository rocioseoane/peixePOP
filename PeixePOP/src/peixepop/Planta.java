/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

/**
 *
 * @author Developer
 */
public class Planta{
    
    private String medioDeVida;
    private String codigo;
    private String nombre;
    
    public Planta(String medioDeVida, String codigo, String nombre) {
        this.medioDeVida = medioDeVida;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getMedioDeVida() {
        return medioDeVida;
    }

    public void setMedioDeVida(String medioDeVida) {
        this.medioDeVida = medioDeVida;
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
    
}
