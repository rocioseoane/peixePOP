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

    private String nombreAcuario;
    private String rutaArchivo;
            
    //Creamos cuatro Arrays vacios para contener los objetos que se vayan creando
    private ArrayList<Sala> inventarioSalas;
    private ArrayList<Estanque> inventarioEstanques;
    private ArrayList<Pez> inventarioPeces;
    private ArrayList<Planta> inventarioPlantas;

    public Acuario(String nombre, String rutaArchivo) {
        nombreAcuario = nombre;
        this.rutaArchivo = rutaArchivo;
        inventarioSalas = new ArrayList<Sala>();
        inventarioEstanques = new ArrayList<Estanque>();
        inventarioPeces = new ArrayList<Pez>();
        inventarioPlantas = new ArrayList<Planta>();
    }

    public String getNombreAcuario() {
        return nombreAcuario;
    }

    public void setNombreAcuario(String nombre) {
        nombreAcuario = nombre;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<Sala> getInventarioSalas() {
        return inventarioSalas;
    }

    public void setInventarioSalas(ArrayList<Sala> inventarioSalas) {
        this.inventarioSalas = inventarioSalas;
    }

    public ArrayList<Estanque> getInventarioEstanques() {
        return inventarioEstanques;
    }

    public void setInventarioEstanques(ArrayList<Estanque> inventarioEstanques) {
        this.inventarioEstanques = inventarioEstanques;
    }

    public ArrayList<Pez> getInventarioPeces() {
        return inventarioPeces;
    }

    public void setInventarioPeces(ArrayList<Pez> inventarioPeces) {
        this.inventarioPeces = inventarioPeces;
    }

    public ArrayList<Planta> getInventarioPlantas() {
        return inventarioPlantas;
    }

    public void setInventarioPlantas(ArrayList<Planta> inventarioPlantas) {
        this.inventarioPlantas = inventarioPlantas;
    }
    
    public void asignarSalas() {
        
        for (Sala sala : inventarioSalas) {
            
        }
        inventarioEstanques = null;
    }
    /**
     * Asigna dos estanques del inventario a cada sala 
     * 
     */
    public void asignarEstanques() {
        int idxActual=0;
        for (Sala sala : inventarioSalas) {
            int contador=0;
            for(int i=idxActual; i<inventarioEstanques.size();i++) {
                if(contador < sala.maxEstanques) {
                    sala.setEstanques(inventarioEstanques.get(i));
                    contador++;
                    idxActual++;
                }
                
            }
        }
        inventarioEstanques = null;
    }
    
    /**
     * Asigna un pez grande, dos medianos y tres pequeños del inventario a cada estanque 
     * 
     */
    public void asignarPeces(){
        for (Sala sala : inventarioSalas) {
            for (Estanque estanque : sala.getEstanques()) {
                
                
            }
            
        }
        
        
    }
    
    
    
    public void mostrarEstanquesSala() {
        for (Sala sala : inventarioSalas) {
            System.out.println("*" + sala.getNombre());
            for(Estanque estanque: sala.getEstanques()) {
                System.out.println("\t" + estanque.getNombre());
            }
        }
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
                    String nombreElemento = linea.substring(5, linea.length());

                    switch (linea.charAt(0)) {
                        //Sala
                        case 'S': {
                            inventarioSalas.add(new Sala(id, nombreElemento, tipo));
                            break;
                        }
                        //Estanque
                        case 'E': {
                            inventarioEstanques.add(new Estanque(id, nombreElemento, tipo));
                            break;
                        }
                        //Animal
                        case 'A': {
                            inventarioPeces.add(new Pez(tipo, id, nombreElemento));
                            break;
                        }
                        //Planta
                        case 'P': {
                            inventarioPlantas.add(new Planta(tipo, id, nombreElemento));
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
