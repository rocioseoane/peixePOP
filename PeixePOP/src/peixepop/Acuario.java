/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Developer
 */
public class Acuario {

    private String nombre;
    private String nombreFichero;
    private ArrayList<Object>[][] inventario;
    
    private final int totalSalas = nObjetosFichero("S");
    private final int totalEstanques = nObjetosFichero("E");
    private final int totalTiburones = nObjetosFichero("T");
    private final int totalPlantas = nObjetosFichero("P");

    public Acuario(String nombre, String nombreFichero) {
        this.nombre = nombre;
        this.nombreFichero = nombreFichero;
        this.inventario = new ArrayList[4][2]; // Hay que inicializarlo con algo
    }

    /**
     * Muestra el inventario que hay en el acurio disponible que son: - Salas -
     * Estanques - Peces - Plantas
     */
    public void mostrarInventario() {
        
    }

    /**
     * 
     * 
     */
    public void rellenarInventario() {
        
    }
    
    /**
     * Método para saber cuantos objetos de esa clase existen en el fichero
     * @param String Meter el character de la clase en mayúsculas
     * @retun int Devuelve el total de clases que hay
     */
    public int nObjetosFichero(String clase) {
        // TODO parametro opcional para saber el segundo campo del fichero por 
        // si lo necesitamos para diferenciar los tiburones en tamaño
        BufferedReader br = null;
        String letra;
        int total = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals(clase)) {
                    total++;
                }
                
                texto = br.readLine();
            }
            
            return total;
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
        
        return total;
    }
    
    /**
     * Lee el fichero pasado por el constructor y muestra el contenido que hay
     * dentro del fichero
     */
    public void mostrarDatosFichero() {
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            System.out.println("----- Contenido del Fichero -----");
            
            while (texto != null) {
                System.out.println(texto);
                texto = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void nombresSalas() {
        BufferedReader br = null;
        Vector<String> v = new Vector();
        String letra;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals("S")) {
                    v.add(texto.split(":")[3]);
                }
                texto = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println(v);
    }
    
}
