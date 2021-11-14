package tienda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private static int numeroFactura = 0;
    private int numero;
    private String codigoCliente;
    private Date fecha;
    private double impTotal;
    private boolean pagado;
    private final ArrayList<LineaFactura> listaLineasFactura;

    public Factura(String codigoCliente, double impTotal, boolean pagado) {
        this.listaLineasFactura = new ArrayList();
        this.numero = numeroFactura++;
        this.codigoCliente = codigoCliente;
        this.fecha = new Date();
        this.impTotal = impTotal;
        this.pagado = pagado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoc() {
        return codigoCliente;
    }

    public void setCodigoc(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getimpTotal() {
        return impTotal;
    }

    public void setimpTotal(double impTotal) {
        this.impTotal = impTotal;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**este metodo recibe como parámetro 
     * @param l un objeto LineaFactura*/
    public void añadirLinea(LineaFactura l) {
        listaLineasFactura.add(l);
    }

    //los siguientes 3 métodos para este MPV no los hemos utilizado
    public void quitarLinea(LineaFactura linea) {
        for (LineaFactura l : listaLineasFactura) {
            if (l.getDescripcion().equals(linea.getDescripcion())) {
                listaLineasFactura.remove(l);
            }
        }
    }

    public void imprimir() {
        System.out.println("Imprimiendo factura...");
        String nombreFichero=numero+".txt";
        String fichero = new File(nombreFichero).getAbsolutePath();
        try {
            FileWriter fw=new FileWriter(fichero, false);
            // Cabecera
            fw.write("#######################################################\n");
            fw.write("#                     FACTURA                         #\n");
            fw.write("#######################################################\n");
            fw.write("##  Número de factura: "+numero+"\n");
            fw.write("##  Tienda Acuario (CIF A11199938H)\n");
            fw.write("##  Fecha: "+fecha.toString()+"\n");
            fw.write("#######################################################\n");
            // Datos del cliente
            fw.write("##  Código Cliente: "+codigoCliente+"\n");
            // ###############################################
            // Pendiente incluir datos auténticos del cliente
            // ###############################################
            fw.write("#######################################################\n");
            // Lineas de la factura
            fw.write("## Cantidad -- Descripcion                    -- Precio\n");
            fw.write("-------------------------------------------------------\n");
            // Recorremos el array para obtener los datos de cada linea
            for(LineaFactura lf : listaLineasFactura){
                fw.write(lf.getCantidad()+" - "+lf.getDescripcion()+" - "+lf.getPrecio()+"\n");
            }
            // Desglose precio, impuestos e importe
            fw.write("-------------------------------------------------------\n");
            double precio = impTotal/1.21;
            double impuestos = impTotal-precio;
            fw.write("## Importe (antes de impuestos)                 "+precio+"\n");
            fw.write("## Impuestos (21%)                              "+impuestos+"\n");
            fw.write("## IMPORTE TOTAL                                "+impTotal+"\n");
            // Observaciones
            fw.write("#######################################################\n");
            fw.write("## Observaciones\n");
            fw.write("## \n");
            fw.write("#######################################################\n");
            fw.close();
        }catch(IOException ioe){
            System.out.println(ioe.getLocalizedMessage());
        }
    }

    public void cobrar() {
        System.out.println("Factura pagada");
        pagado = true;
    }
}
