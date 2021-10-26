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
public class Acuario {

    private String nombre;
    private String rutaArchivo;
            
    //Creamos cuatro Arrays vacios para contener los objetos que se vayan creando
    private ArrayList<Sala> inventarioSalas;
    private ArrayList<Estanque> inventarioEstanques;
    private ArrayList<Pez> inventarioPeces;
    private ArrayList<Planta> inventarioPlantas;

    public Acuario(String nombre, String rutaArchivo) {
        this.nombre = nombre;
        this.rutaArchivo = rutaArchivo;
        inventarioSalas = new ArrayList<Sala>();
        inventarioEstanques = new ArrayList<Estanque>();
        inventarioPeces = new ArrayList<Pez>();
        inventarioPlantas = new ArrayList<Planta>();
    }

    
    /**
     * Lee un fichero dado por parametro y clasifica los objetos leídos
     */
    public void clasificarObjetos() {
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        File archivo = new File(rutaArchivo);

        // Si el archivo existe clasificamos las entradas según su tipo de objeto en ArrayLists
        if (archivo.exists()) {
            try {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                linea = br.readLine();
                while (linea != null) {
                    String tipo = linea.substring(1, 2);
                    String id = linea.substring(2, 5);
                    String nombre = linea.substring(5, linea.length());

                    switch (linea.charAt(0)) {
                        //Sala
                        case 'S': {
                            inventarioSalas.add(new Sala(id, nombre, tipo));
                            break;
                        }
                        //Estanque
                        case 'E': {
                            inventarioEstanques.add(new Estanque(id, nombre, tipo));
                            break;
                        }
                        //Animal
                        case 'A': {
                            inventarioPeces.add(new Pez(tipo, id, nombre));
                            break;
                        }
                        //Planta
                        case 'P': {
                            inventarioPlantas.add(new Planta(tipo, id, nombre));
                            break;
                        }
                    }
                    linea = br.readLine();
                }
            } catch (IOException ioe) {
                System.out.println("Archivo no existe");
                System.exit(0);
            }
        }
    }

    /**
     *
     *
     */
    public void mostrarInventario() {
        //Salas
        System.out.println("***********Salas*************");
        for (int i = 0; i < inventarioSalas.size(); i++) {
            Sala temp = inventarioSalas.get(i);
            System.out.println("Sala: " + temp.getTipo() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Estanque
        System.out.println("***********Estanques*************");
        for (int i = 0; i < inventarioEstanques.size(); i++) {
            Estanque temp = inventarioEstanques.get(i);
            System.out.println("Estanque: " + temp.getTipo() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Animales
        System.out.println("***********Animales*************");
        for (int i = 0; i < inventarioPeces.size(); i++) {
            Pez temp = inventarioPeces.get(i);
            System.out.println("Animal: " + temp.getTamano() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Plantas
        System.out.println("***********Plantas*************");
        for (int i = 0; i < inventarioPlantas.size(); i++) {
            Planta temp = inventarioPlantas.get(i);
            System.out.println("Planta: " + temp.getMedioDeVida() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
    }

    // private void mostrarObjetos();  mirar para optimizar los for de mostrar inventario
}
