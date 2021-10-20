package peixepop;

public class Animal {
    private String reproduccion;
    private int gestacion;
    private boolean grupo;
    private double peso;
    private boolean alimentado;

    public String getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(String reproduccion) {
        this.reproduccion = reproduccion;
    }

    public int getGestacion() {
        return gestacion;
    }

    public void setGestacion(int gestacion) {
        this.gestacion = gestacion;
    }

    public boolean isGrupo() {
        return grupo;
    }

    public void setGrupo(boolean grupo) {
        this.grupo = grupo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isAlimentado() {
        return alimentado;
    }

    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
    }

    
    public Animal(String reproduccion, int gestacion, boolean grupo, double peso, boolean alimentado) {
        this.reproduccion = reproduccion;
        this.gestacion = gestacion;
        this.grupo = grupo;
        this.peso = peso;
        this.alimentado = alimentado;
    }
    
    
}
