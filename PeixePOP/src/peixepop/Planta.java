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
public class Planta {
    
    private double altura;
    private String bioma;
    private boolean podada;

    public Planta(double altura, String bioma, boolean podada) {
        this.altura = altura;
        this.bioma = bioma;
        this.podada = podada;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getBioma() {
        return bioma;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public boolean isPodada() {
        return podada;
    }

    public void setPodada(boolean podada) {
        this.podada = podada;
    }
    
    
}
