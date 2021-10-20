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
public class Sala {
    
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean apagada;
    private boolean limpia;

    public Sala(String codigo, String nombre, String tipo, boolean apagada, boolean limpia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.apagada = apagada;
        this.limpia = limpia;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isApagada() {
        return this.apagada;
    }

    public void setIluminacion(boolean apagada) {
        this.apagada = apagada;
    }

    public boolean isLimpia() {
        return limpia;
    }

    public void setLimpia(boolean limpia) {
        this.limpia = limpia;
    }
    
    
    
}
