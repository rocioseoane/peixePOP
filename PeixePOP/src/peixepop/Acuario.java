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

    // Para buscar por el inventario
    private final int idSala = 0;
    private final int idEstanque = 1;
    private final int idTiburon = 2;
    private final int idPlanta = 3;
    
    // Atributos de nuestro acuario
    private String nombre;
    private String nombreFichero;
    private ArrayList<ArrayList<Object>> inventario;
    
    // Cuantos objetos tiene el acuario
    private int totalSalas;
    private int totalEstanques;
    private int totalTiburones;
    private int totalPlantas;

    public Acuario(String nombre, String nombreFichero) {
        this.nombre = nombre;
        this.nombreFichero = nombreFichero;
        this.inventario = new ArrayList<ArrayList<Object>>(); // Hay que inicializarlo con algo
        this.totalSalas = nObjetosFichero("S");
        this.totalEstanques = nObjetosFichero("E");
        this.totalTiburones = nObjetosFichero("T");
        this.totalPlantas = nObjetosFichero("P");
    }

    /**
     * Muestra el inventario que hay en el acurio disponible que son: - Salas -
     * Estanques - Peces - Plantas
     */
    public void mostrarInventario() {
        System.out.println(inventario);
    }

    /**
     * 
     * 
     */
    public void rellenarInventario() {
        agregarSalas();
        agregarEstanques();
        agregarTiburones();
        agregarPlantas();
    }
    
    /**
     * Agrega las salas que hay en el fichero dado por parámetro en el 
     * constructor
     */
    private void agregarSalas() {
        String codigoSala;
        String nombreSala;
        String tipoSala;
        
        inventario.add(new ArrayList<Object>());

        // Crear objetos salas
        for (int i = 0; i < totalSalas; i++) {
            codigoSala = atributosSalas()[i][2];
            nombreSala = atributosSalas()[i][3];
            tipoSala = atributosSalas()[i][1];
            inventario.get(idSala).add(new Sala(codigoSala, nombreSala, tipoSala).getNombre());
        }
    }
    
    private void agregarEstanques() {
        String codigoEstanque;
        String nombreEstanque;
        String tipoEstanque;
        
        inventario.add(new ArrayList<Object>());
        
        // Crear objetos estanques
        for (int i = 0; i < totalEstanques; i++) {
            codigoEstanque = atributosEstanques()[i][2];
            nombreEstanque = atributosEstanques()[i][3];
            tipoEstanque = atributosEstanques()[i][1];
            inventario.get(idEstanque).add(new Estanque(codigoEstanque, nombreEstanque, tipoEstanque).getNombre());
        }
    }
    
    private void agregarTiburones() {
        String codigoTiburon;
        String nombreTiburon;
        String tamanoTiburon;
        
        inventario.add(new ArrayList<Object>());
        
        // Crear objetos estanques
        for (int i = 0; i < totalTiburones; i++) {
            codigoTiburon = atributosTiburones()[i][2];
            nombreTiburon = atributosTiburones()[i][3];
            tamanoTiburon = atributosTiburones()[i][1];
            inventario.get(idTiburon).add(new Tiburon(tamanoTiburon, codigoTiburon, nombreTiburon).getNombre());
        }
    }
    
    private void agregarPlantas() {
        String codigoPlanta;
        String nombrePlanta;
        String medioPlanta;
        
        inventario.add(new ArrayList<Object>());
        
        // Crear objetos estanques
        for (int i = 0; i < totalPlantas; i++) {
            codigoPlanta = atributosPlantas()[i][2];
            nombrePlanta = atributosPlantas()[i][3];
            medioPlanta = atributosPlantas()[i][1];
            inventario.get(idPlanta).add(new Planta(medioPlanta, codigoPlanta, nombrePlanta).getNombre());
        }
    }
    
    /**
     * Método para saber cuantos objetos de esa clase existen en el fichero
     * @param String Meter el character de la clase en mayúsculas
     * @return int Devuelve el total de clases que hay
     */
    private int nObjetosFichero(String clase) {
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
    
    /**
     * Método que lee el fichero pasado por el constructor, busca las salas que
     * hay y guarda cada atributo de cada sala en un array 2d
     * @return String[][] Un array 2d con los atributos de las salas encontradas
     */
    private String[][] atributosSalas() {
        BufferedReader br = null;
        String[][] salas = new String[totalSalas][4];
        String letra;
        
        int nSala = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals("S")) {
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
    
    /**
     * Método que lee el fichero pasado por el constructor, busca los estanques 
     * que hay y guarda cada atributo de cada sala en un array 2d
     * @return String[][] Un array 2d con los atributos de las estanques encontrados
     */
    private String[][] atributosEstanques() {
        BufferedReader br = null;
        String[][] estanques = new String[totalEstanques][4];
        String letra;
        
        int nEstanque = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals("E")) {
                    for (int i = 0; i < 4; i++) {
                        estanques[nEstanque][i] = texto.split(":")[i];
                    }
                    nEstanque++;
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
        
        return estanques;
    }
    
    private String[][] atributosTiburones() {
        BufferedReader br = null;
        String[][] tiburones = new String[totalTiburones][4];
        String letra;
        
        int nTiburon = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals("T")) {
                    for (int i = 0; i < 4; i++) {
                        tiburones[nTiburon][i] = texto.split(":")[i];
                    }
                    nTiburon++;
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
        
        return tiburones;
    }
    
    private String[][] atributosPlantas() {
        BufferedReader br = null;
        String[][] plantas = new String[totalPlantas][4];
        String letra;
        
        int nPlantas = 0;
        
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            
            while (texto != null) {
                letra = texto.split(":")[0]; 
                if (letra.equals("P")) {
                    for (int i = 0; i < 4; i++) {
                        plantas[nPlantas][i] = texto.split(":")[i];
                    }
                    nPlantas++;
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
        
        return plantas;
    }
}
