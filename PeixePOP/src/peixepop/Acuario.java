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

    // Cuantos objetos tiene tipo el acuario por separado
    private int totalSalas;
    private int totalEstanques;
    private int totalTiburones;
    private int totalPlantas;

    private MetodosAuxiliares ma;

    // Falta este docstring
    public Acuario(String nombre, String nombreFichero) {
        this.nombre = nombre;
        this.nombreFichero = nombreFichero;

        // Inventarios
        this.inventarioSalas = new ArrayList<Sala>();
        this.inventarioEstanques = new ArrayList<Estanque>();
        this.inventarioTiburones = new ArrayList<Tiburon>();

        // Cuantos objetos hay de cada tipo
        this.totalSalas = nObjetosFichero("S");
        this.totalEstanques = nObjetosFichero("E");
        this.totalTiburones = nObjetosFichero("T");
        this.totalPlantas = nObjetosFichero("P");
        ma = new MetodosAuxiliares();
    }

    /**
     * Muestra el inventario disponible que hay en el acuario que son: - Salas -
     * Estanques - Tiburones - Plantas
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

    }
    
    public void asignarJerarquia() {
        asignarEstanquesACadaSala();
        asignarTiburonesACadaEstanque();
    }
    
    // mirar
    public void mostrarJeraquia() {
        for (Sala sala : inventarioSalas) {
            System.out.println(sala.getNombre() + ":");
            for (Estanque estanque : inventarioEstanques) {
                System.out.println("\t" + estanque.getNombre() + ":");
            }
        }
    }
    

    // Asigna 2 estanques a cada sala, si pones impares pone ArrayIndexOutOfBoundsException
    public void asignarEstanquesACadaSala() {
        int[] numAleatorios = ma.numerosAleatoriosNoRepetidos(0, totalEstanques, totalEstanques);
        int cont = 0;

        for (int i = 0; i < inventarioSalas.size(); i++) {
            for (int j = 0; j < inventarioSalas.get(0).maxEstanques; j++) {
                inventarioSalas.get(i).setEstanques(inventarioEstanques.get(numAleatorios[cont]));
                cont++;
            }
        }
    }

    // mirar
    public void asignarTiburonesACadaEstanque() {
        int[] numAleatorios = ma.numerosAleatoriosNoRepetidos(0, totalTiburones, totalTiburones);
        int cont = 0;

        for (int i = 0; i < inventarioEstanques.size(); i++) {
            for (int j = 0; j < inventarioEstanques.get(0).maxTiburones; j++) {
                inventarioEstanques.get(i).setTiburon(inventarioTiburones.get(numAleatorios[cont]));
                cont++;
            }
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
     * Método para calcular cuantos objetos de esa clase existen en el fichero
     * pasado por el constructor
     *
     * @param String Letra de la clase en mayúsculas a contar
     * @return int Devuelve el total de clases que hay
     */
    private int nObjetosFichero(String clase) {
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
     * Método que lee el fichero pasado por el constructor, busca los objetos
     * que hay y guarda cada atributo de cada objeto en su array
     *
     * @param String Atributo de los objetos que quieres
     * @param int Total de objetos que hay en el fichero para definir el array
     * 2d
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
