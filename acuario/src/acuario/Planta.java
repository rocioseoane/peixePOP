package acuario;

import common.Especie;

/**
 *
 * @author Developer
 */
class Planta extends Especie{
    
    private String medioDeVida;
    
    public Planta(String medioDeVida, String codigo, String nombre) {
        super(codigo, nombre);
        this.medioDeVida=medioDeVida;

    }

    /**
     * @return String Devuélve el medio de vida
     */
    public String getMedioDeVida() {
        return medioDeVida;
    }

    /**
     * @param medioDeVida Se le asigna un medio de vida a la planta
     */
    public void setMedioDeVida(String medioDeVida) {
        this.medioDeVida = medioDeVida;
    }
    
}
