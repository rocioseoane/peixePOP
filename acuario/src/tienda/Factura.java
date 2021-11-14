package tienda;

import common.ConnDB;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Factura {
    
    private int numero;
    private String codigoCliente;
    private String fecha;
    private double importeTotal;
    private boolean pagado;
    private final ArrayList<LineaFactura> listaLineasFactura=new ArrayList();

    public Factura(int numero, String codigoCliente, String fecha, double importeTotal, boolean pagado) {
        this.numero=numero;
        this.codigoCliente = codigoCliente;
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.pagado = pagado;
    }
    
    public Factura (String codigoCliente, double importeTotal, boolean pagado){
        this.codigoCliente=codigoCliente;
        this.importeTotal=importeTotal;
        this.pagado=pagado;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getimpTotal() {
        return importeTotal;
    }

    public void setimpTotal(double importeTotal) {
        this.importeTotal = importeTotal;
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
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            FileWriter fw=new FileWriter(fichero, false);
            // Cabecera
            fw.write("#######################################################\n");
            fw.write("#                     FACTURA                         #\n");
            fw.write("#######################################################\n");
            fw.write("##  Número de factura: "+numero+"\n");
            fw.write("##  Tienda Acuario (CIF A11199938H)\n");
            fw.write("##  Fecha: "+fecha+"\n");
            fw.write("#######################################################\n");
            // Datos del cliente
            ConnDB bbdd=ConnDB.getInstance();
            Cliente c=bbdd.getClienteByCodigo(codigoCliente);
            fw.write("##  Código Cliente: "+c.getCodigo()+"\n");
            fw.write("##  Nombre Cliente: "+c.getNombre()+"\n");
            fw.write("##  Direccion: "+c.getDireccion()+"\n");
            fw.write("##  Teléfono: "+c.getTelefono()+"\n");
            fw.write("#######################################################\n");
            // Lineas de la factura
            fw.write("## Cantidad -- Descripcion                    -- Precio\n");
            fw.write("-------------------------------------------------------\n");
            // Recorremos el array para obtener los datos de cada linea
            for(LineaFactura lf : listaLineasFactura){
                String cantidad=String.format("%11d",lf.getCantidad());
                String descripcion=String.format("%-30s",lf.getDescripcion());
                String precio=String.format(df.format(lf.getPrecio()));
                fw.write(cantidad+" -- "+descripcion+" -- "+precio+"\n");
            }
            // Desglose precio, impuestos e importe
            fw.write("-------------------------------------------------------\n");
            double precio = importeTotal/1.21;
            double impuestos = importeTotal-precio;
            fw.write("## Importe (antes de impuestos)                  "+df.format(precio)+"\n");
            fw.write("## Impuestos (21%)                               "+df.format(impuestos)+"\n");
            fw.write("## IMPORTE TOTAL                                 "+df.format(importeTotal)+"\n");
            // Observaciones
            fw.write("#######################################################\n");
            fw.write("## Observaciones\n");
            fw.write("## \n");
            fw.write("#######################################################\n");
            fw.close();
            
            System.out.println("Factura guardada como "+fichero);
        }catch(IOException ioe){
            System.out.println(ioe.getLocalizedMessage());
        }
    }

    public void cobrar() {
        System.out.println("Factura pagada");
        pagado = true;
    }
}
