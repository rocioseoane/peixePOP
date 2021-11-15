package acuario;

import common.ConnDB;

/**
 * Clase para crear un objeto tipo Tiburón
 * @author Angel, Jose, Miguel, Paulo
 */
public class Tiburon extends Especie{
    
    private final ConnDB bbdd=ConnDB.getInstance();
    private String tamano;
    
    public Tiburon(String codigo, String nombre, String tamano, String codigo_estanque){
        super(codigo, nombre);
        this.setEstanque(bbdd.getEstanqueByCodigo(codigo_estanque));
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
