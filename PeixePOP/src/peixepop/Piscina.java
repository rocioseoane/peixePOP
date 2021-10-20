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
public class Piscina {
    
    private String codigo;
    private String nombre;
    private Double temperaturaAgua;
    private String tipo;
    private boolean aguaSalada; 
    private boolean limpia;

    public Piscina(String codigo, String nombre, Double temperaturaAgua, String tipo, boolean aguaSalada, boolean limpia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.temperaturaAgua = temperaturaAgua;
        this.tipo = tipo;
        this.aguaSalada = aguaSalada;
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

    public Double getTemperaturaAgua() {
        return temperaturaAgua;
    }

    public void setTemperaturaAgua(Double temperaturaAgua) {
        this.temperaturaAgua = temperaturaAgua;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAguaSalada() {
        return aguaSalada;
    }

    public void setAguaSalada(boolean aguaSalada) {
        this.aguaSalada = aguaSalada;
    }

    public boolean isLimpia() {
        return limpia;
    }

    public void setLimpia(boolean limpia) {
        this.limpia = limpia;
    }

}
