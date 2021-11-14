package acuario;

import common.Especie;

/**
 * Clase para crear un objeto tipo Tiburón
 * @author Angel, Jose, Miguel, Paulo
 */
class Tiburon extends Especie{
    
    private String tamano;
    
    public Tiburon(String tamano, String codigo, String nombre){
        super(codigo, nombre);
        this.tamano=tamano;
    }
    
    /**
     * @return String Devuélve el tamaño del tiburón
     */
    public String getTamano() {
        return tamano;
    }
    
    /**
     * @param tamano Se le asigna un tamaño al tiburón
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
}
