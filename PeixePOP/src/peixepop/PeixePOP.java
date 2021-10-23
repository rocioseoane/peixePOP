/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class PeixePOP {
    //Creamos cuatro Arrays vacios para contener los objetos que se vayan creando
    static ArrayList<Sala> salas = new ArrayList<Sala>();
    static ArrayList<Estanque> estanques = new ArrayList<Estanque>();
    static ArrayList<Pez> peces = new ArrayList<Pez>();
    static ArrayList<Planta> plantas = new ArrayList<Planta>();
    
    public static void main(String[] args) {
        // Creamos un String con el nombre del archivo con los datos
        String data = "Datos.txt";
        // Creamos un String con la ruta absoluta del archivo que le pasamos
        String rutaAbsoluta = new File(data).getAbsolutePath();
        // Para ver la ruta del archivo usado para datos descomentar la siguiente línea
        System.out.println(rutaAbsoluta);
        File archivo = new File(rutaAbsoluta);
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        if (archivo.exists()) {
            try {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                linea = br.readLine();
                while(linea != null) {
                    clasificar(linea);
                    linea = br.readLine();
                }
            } catch (IOException ioe) {
                System.out.println("Archivo no existe");
                System.exit(0);
            }
        }

    }
    static void clasificar(String linea) {
        
        String id;
        String nombre;
        String tipo;
        
        switch(linea.charAt(0)) {
            //Sala
            case 'S': {
                id = linea.substring(1,3);
                nombre = linea.substring(3,linea.length());
                System.out.println("Sala: " + id + " " + nombre);
                break;
            }
            //Estanque
            case 'E': {
                id = linea.substring(1,4);
                nombre = linea.substring(4,linea.length());
                System.out.println("Estanque: " + id + " " + nombre);
                break;
            }
            //Animal
            case 'A': {
                tipo = linea.substring(1,2);
                id = linea.substring(2,5);
                nombre = linea.substring(5,linea.length());
                System.out.println("Animal: " + tipo + " " + id + " " + nombre);
                break;
            }
            //Planta
            case 'P': {
                tipo = linea.substring(1,2);
                id = linea.substring(2,5);
                nombre = linea.substring(5,linea.length());
                System.out.println("Planta: " + tipo + " " + id + " " + nombre);
                break;
            }
        } 
    }
    

}
