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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Developer
 */
public class Acuario {
    
    private final int totalAtributos = 4;
    
    // Atributos de nuestro acuario
    private String nombre;
    private String nombreFichero;
    
    private ArrayList<Sala> inventarioSalas;
    private ArrayList<Estanque> inventarioEstanques;
    private ArrayList<Tiburon> inventarioTiburones;
    private ArrayList<Planta> inventarioPlantas;

    // Cuantos objetos tiene tipo el acuario por separado
    private int totalSalas;
    private int totalEstanques;
    private int totalTiburones;
    private int totalPlantas;

    // Falta este docstring
    public Acuario(String nombre, String nombreFichero) {
        this.nombre = nombre;
        this.nombreFichero = nombreFichero;
        
        // Inventarios
        this.inventarioSalas = new ArrayList<Sala>();
        this.inventarioEstanques = new ArrayList<Estanque>();
        this.inventarioTiburones = new ArrayList<Tiburon>();
        this.inventarioPlantas = new ArrayList<Planta>();
        
        // Cuantos objetos hay de cada tipo
        this.totalSalas = nObjetosFichero("S");
        this.totalEstanques = nObjetosFichero("E");
        this.totalTiburones = nObjetosFichero("T");
        this.totalPlantas = nObjetosFichero("P");
    }

    /**
     * Muestra el inventario disponible que hay en el acuario que son: 
     *      - Salas
     *      - Estanques
     *      - Tiburones
     *      - Plantas
     */
    public void mostrarInventario() {
        System.out.println("----- INVENTARIO -----");
        
        // Mostrar salas
        System.out.println("******* Salas *******");
        for (Sala sala : inventarioSalas) {
            System.out.println(sala.getNombre());
        }
        
        // Mostrar estanques
        System.out.println("***** Estanques *****");
        for (Estanque estanque : inventarioEstanques) {
            System.out.println(estanque.getNombre());
        }
        
        // Mostrar tiburones
        System.out.println("***** Tiburones *****");
        for (Tiburon tiburon : inventarioTiburones) {
            System.out.println(tiburon.getNombre());
        }
        
        // Mostrar plantas
        System.out.println("**** Plantas ****");
        for (Planta planta : inventarioPlantas) {
            System.out.println(planta.getNombre());
        }
    }

    // Asigna 2 estanques a cada sala, si pones impares pone ArrayIndexOutOfBoundsException
    public void asignarEstanquesACadaSala() {
        int[] numAleatorios = numerosAleatoriosNoRepetidos(0, totalEstanques, totalEstanques);
        shuffleArray(numAleatorios);
        int cont = 0;
        
        for (int i = 0; i < inventarioSalas.size(); i++) {
            System.out.println(inventarioSalas.get(i).getNombre());
            for (int j = 0; j < inventarioSalas.get(0).maxEstanques; j++) {
                inventarioSalas.get(i).setEstanques(inventarioEstanques.get(numAleatorios[cont]));
                System.out.println("    " + inventarioSalas.get(i).getEstanques().get(j).getNombre());
                cont++;
            }
        }
    }
    
    // mirar
    public void asignarTiburonesACadaEstanque() {
        
        
    }
    
    // Genera un array de int con numeros que le pasas por parametro
    public int[] numerosAleatoriosNoRepetidos(int start, int end, int count) {
        Random rng = new Random();

        int[] result = new int[count];
        int cur = 0;
        int remaining = end - start;
        for (int i = start; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        return result;
    }
    
    // Cambia de posicion el array de numeros generados aleatoriamente
    public void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    
    /**
     * Rellena el inventario con los objetos que se encontraron en el fichero
     * dado en el constructor
     */
    public void rellenarInventario() {
        agregarSalas();
        agregarEstanques();
        agregarTiburones();
        agregarPlantas();
    }
    
    /**
     * Agrega las salas que se encontraron en el fichero pasado en el
     * constructor al arrayList inventarioSalas
     */
    private void agregarSalas() {
        String codigoSala;
        String nombreSala;
        String tipoSala;
        
        for (int i = 0; i < totalSalas; i++) {
            codigoSala = getAtributosObj("S", totalSalas)[i][2];
            nombreSala = getAtributosObj("S", totalSalas)[i][3];
            tipoSala = getAtributosObj("S", totalSalas)[i][1];
            inventarioSalas.add(new Sala(codigoSala, nombreSala, tipoSala));
        }
    }
   
    /**
     * Agrega los estanques que se encontraron en el fichero pasado en el
     * constructor al arrayList inventarioEstanques
     */
    private void agregarEstanques() {
        String codigoEstanque;
        String nombreEstanque;
        String tipoEstanque;
        
        for (int i = 0; i < totalEstanques; i++) {
            codigoEstanque = getAtributosObj("E", totalEstanques)[i][2];
            nombreEstanque = getAtributosObj("E", totalEstanques)[i][3];
            tipoEstanque = getAtributosObj("E", totalEstanques)[i][1];
            inventarioEstanques.add(new Estanque(codigoEstanque, nombreEstanque, tipoEstanque));
        }
    }
    
    /**
     * Agrega los tiburones que se encontraron en el fichero pasado en el
     * constructor al arrayList inventarioTiburones
     */
    private void agregarTiburones() {
        String codigoTiburon;
        String nombreTiburon;
        String tamanoTiburon;
        
        for (int i = 0; i < totalTiburones; i++) {
            codigoTiburon = getAtributosObj("T", totalTiburones)[i][2];
            nombreTiburon = getAtributosObj("T", totalTiburones)[i][3];
            tamanoTiburon = getAtributosObj("T", totalTiburones)[i][1];
            inventarioTiburones.add(new Tiburon(tamanoTiburon, codigoTiburon, nombreTiburon));
        }
    }
    
    /**
     * Agrega las plantas que se encontraron en el fichero pasado en el
     * constructor al arrayList inventarioPlantas
     */
    private void agregarPlantas() {
        String codigoPlanta;
        String nombrePlanta;
        String medioPlanta;
        
        for (int i = 0; i < totalPlantas; i++) {
            codigoPlanta = getAtributosObj("P", totalPlantas)[i][2];
            nombrePlanta = getAtributosObj("P", totalPlantas)[i][3];
            medioPlanta = getAtributosObj("P", totalPlantas)[i][1];
            inventarioPlantas.add(new Planta(medioPlanta, codigoPlanta, nombrePlanta));
        }
    }
    
    /**
     * Método para calcular cuantos objetos de esa clase existen en el fichero
     * pasado por el constructor
     * @param String Letra de la clase en mayúsculas a contar
     * @return int Devuelve el total de clases que hay
     */
    private int nObjetosFichero(String clase) {
        // TODO: parametro opcional para saber el segundo campo del fichero por 
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
    
    /**
     * Método que lee el fichero pasado por el constructor, busca las salas que
     * hay y guarda cada atributo de cada sala en un array 2d
     * @param String Atributo de los objetos que quieres
     * @param int Total de objetos que hay en el fichero para definir el array 2d
     * @return String[][] Un array 2d con los atributos de las salas encontradas
     */
    private String[][] getAtributosObj(String atributo, int totalObj) {
        BufferedReader br = null;
        String[][] salas = new String[totalObj][totalAtributos];
        String letra;
        
        int nSala = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals(atributo)) {
                    for (int i = 0; i < 4; i++) {
                        salas[nSala][i] = texto.split(":")[i];
                    }
                    nSala++;
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
        
        return salas;
    }
    
}
