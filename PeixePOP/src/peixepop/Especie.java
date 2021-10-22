
package peixepop;

public class Especie {
    private String codigo;
    private double tempMax;
    private double tempMin;
    private String nombreCientifico;
    private String nombreComun;
    private int edad;
    private String fechaNac;
    private String clima;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    
    public void calcularEdad() {
        //TODO
    }

    public Especie(String codigo, double tempMax, double tempMin, 
                   String nombreCientifico, String nombreComun, int edad, 
                   String fechaNac, String clima) {
        this.codigo = codigo;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.nombreCientifico = nombreCientifico;
        this.nombreComun = nombreComun;
        this.edad = edad;
        this.fechaNac = fechaNac;
        this.clima = clima;
    }
    
}
