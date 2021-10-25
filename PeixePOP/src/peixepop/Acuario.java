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

    //Creamos cuatro Arrays vacios para contener los objetos que se vayan creando
    static ArrayList<Sala> salas = new ArrayList<Sala>();
    static ArrayList<Estanque> estanques = new ArrayList<Estanque>();
    static ArrayList<Pez> peces = new ArrayList<Pez>();
    static ArrayList<Planta> plantas = new ArrayList<Planta>();

    public Acuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Sala> getSalas() {
        return salas;
    }

    public static void setSalas(ArrayList<Sala> salas) {
        Acuario.salas = salas;
    }

    public static ArrayList<Estanque> getEstanques() {
        return estanques;
    }

    public static void setEstanques(ArrayList<Estanque> estanques) {
        Acuario.estanques = estanques;
    }

    public static ArrayList<Pez> getPeces() {
        return peces;
    }

    public static void setPeces(ArrayList<Pez> peces) {
        Acuario.peces = peces;
    }

    public static ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public static void setPlantas(ArrayList<Planta> plantas) {
        Acuario.plantas = plantas;
    }

    /**
     * Lee un fichero dado por parametro y clasifica los objetos leídos
     *
     * @param fichero Nombre del archivo a leer
     */
    public void clasificarObjetos(File fichero) {
        FileReader fr = null;
        BufferedReader br = null;
        String linea;

        // Si el archivo existe clasificamos las entradas según su tipo de objeto en ArrayLists
        if (fichero.exists()) {
            try {
                fr = new FileReader(fichero);
                br = new BufferedReader(fr);
                linea = br.readLine();
                while (linea != null) {
                    String tipo = linea.substring(1, 2);
                    String id = linea.substring(2, 5);
                    String nombre = linea.substring(5, linea.length());

                    switch (linea.charAt(0)) {
                        //Sala
                        case 'S': {
                            salas.add(new Sala(id, nombre, tipo));
                            break;
                        }
                        //Estanque
                        case 'E': {
                            estanques.add(new Estanque(id, nombre, tipo));
                            break;
                        }
                        //Animal
                        case 'A': {
                            peces.add(new Pez(tipo, id, nombre));
                            break;
                        }
                        //Planta
                        case 'P': {
                            plantas.add(new Planta(tipo, id, nombre));
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
        for (int i = 0; i < salas.size(); i++) {
            Sala temp = salas.get(i);
            System.out.println("Sala: " + temp.getTipo() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Estanque
        System.out.println("***********Estanques*************");
        for (int i = 0; i < estanques.size(); i++) {
            Estanque temp = estanques.get(i);
            System.out.println("Estanque: " + temp.getTipo() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Animales
        System.out.println("***********Animales*************");
        for (int i = 0; i < peces.size(); i++) {
            Pez temp = peces.get(i);
            System.out.println("Animal: " + temp.getTamano() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
        //Plantas
        System.out.println("***********Plantas*************");
        for (int i = 0; i < plantas.size(); i++) {
            Planta temp = plantas.get(i);
            System.out.println("Planta: " + temp.getMedioDeVida() + " " + temp.getCodigo() + " " + temp.getNombre());
        }
    }

    // private void mostrarObjetos();  mirar para optimizar los for de mostrar inventario
}
