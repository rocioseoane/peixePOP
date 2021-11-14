package peixepop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase para crear un objeto tipo Acuario
 * @author Angel, Jose, Miguel, Paulo
 */
public class Acuario {

    // Total de campos que tiene cada objeto
    private final int TOTAL_CAMPOS = 4;

    // Nombre de nuestro acuario
    private String nombre;
    
    // Fichero donde recogemos los datos
    private String nombreFichero;

    // Donde guardamos los datos del fichero dado por el constructor
    private ArrayList<Sala> inventarioSalas;
    private ArrayList<Estanque> inventarioEstanques;
    private ArrayList<Tiburon> inventarioTiburones;

    // Cuantos objetos se encontraron en el fichero dado por el constructor
    private int totalSalas;
    private int totalEstanques;
    private int totalTiburones;
    private int totalPlantas;

    // Objeto que nos proporciona metodos que necesitamos pero que no son
    // propios del acuario
    private MetodosAuxiliares ma;

    /**
     * Constructor por defecto
     * @param nombre Nombre del acuario
     * @param nombreFichero Fichero por donde recogemos los datos
     */
    public Acuario(String nombre, String nombreFichero) {
        this.nombre = nombre;
        this.nombreFichero = nombreFichero;
        this.inventarioSalas = new ArrayList<Sala>();
        this.inventarioEstanques = new ArrayList<Estanque>();
        this.inventarioTiburones = new ArrayList<Tiburon>();
        this.totalSalas = nObjetosFichero("S");
        this.totalEstanques = nObjetosFichero("E");
        this.totalTiburones = nObjetosFichero("T");
        this.totalPlantas = nObjetosFichero("P");
        ma = new MetodosAuxiliares();
    }

    /**
     * Muestra el inventario disponible que hay en el acuario que son:
     *      - Salas
     *      - Estanques
     *      - Tiburones
     */
    public void mostrarInventario() {
        System.out.println("--- INVENTARIO DEL ACUARIO " + nombre.toUpperCase() + " ---");

        // Mostrar salas
        System.out.println("\t******* Salas *******");
        for (Sala sala : inventarioSalas) {
            System.out.println("\t" + sala.getNombre());
        }

        // Mostrar estanques
        System.out.println("\t***** Estanques *****");
        for (Estanque estanque : inventarioEstanques) {
            System.out.println("\t" + estanque.getNombre());
        }

        // Mostrar tiburones
        System.out.println("\t***** Tiburones *****");
        for (Tiburon tiburon : inventarioTiburones) {
            System.out.println("\t" + tiburon.getDescripcion());
        }
    }
    
    /**
     * Se le asigna a cada sala sus estanques correspondientes y en cada 
     * estanque se le asignan los tiburones correspondientes
     */
    public void asignarJerarquia() {
        asignarEstanquesACadaSala();
        asignarTiburonesACadaEstanque();
    }
    
    /**
     * Se muestra como están organizadas las salas, estanques y tiburones en el
     * acuario
     */
    public void mostrarJeraquia() {
        // Identificador para pasar por todos los estanques
        int idEstanque = 0;
        
        // Enseña cada sala
        for (int i = 0; i < totalSalas; i++) {
            System.out.println(inventarioSalas.get(i).getNombre() + ":");
            // Se muestran los 2 estanques que contiene la sala
            for (int j = 0; j < inventarioSalas.get(0).maxEstanques; j++) {
                System.out.println("    " + inventarioSalas.get(i).getEstanques().get(j).getNombre() + ":");
                // Se muestran los 6 tiburones que hay en cada estanque
                for (int k = 0; k < inventarioEstanques.get(0).maxTiburones; k++) {
                    System.out.println("\t" + inventarioEstanques.get(idEstanque).getTiburones().get(k).getDescripcion());
                }
                idEstanque++;
            }
        }
    }
    
    /**
     * A cada sala encontrada en el fichero dado por el constructor se le asigna
     * 2 estanques
     */
    private void asignarEstanquesACadaSala() {
        // Definir un array de números aleatorios no repetidos entre 0 y el
        // total de estanques encontrados en el fichero pasado por el
        // constructor
        int[] numAleatorios = ma.numerosAleatoriosNoRepetidos(0, totalEstanques, totalEstanques);
        
        // Contador para no reiniciar el array de numAleatorios
        int cont = 0;

        for (int i = 0; i < inventarioSalas.size(); i++) {
            for (int j = 0; j < inventarioSalas.get(0).maxEstanques; j++) {
                inventarioSalas.get(i).agregarEstanques(inventarioEstanques.get(numAleatorios[cont]));
                cont++;
            }
        }
    }
    
    /**
     * En cada estanque se le asignan 6 tiburones
     */
    private void asignarTiburonesACadaEstanque() {
        // Definir un array de números aleatorios no repetidos entre 0 y el
        // total de estanques encontrados en el fichero pasado por el
        // constructor
        int[] numAleatorios = ma.numerosAleatoriosNoRepetidos(0, totalTiburones, totalTiburones);
        
        // Contador para no reiniciar el array de numAleatorios
        int cont = 0;

        for (int i = 0; i < inventarioEstanques.size(); i++) {
            for (int j = 0; j < inventarioEstanques.get(0).maxTiburones; j++) {
                inventarioEstanques.get(i).agregarTiburones(inventarioTiburones.get(numAleatorios[cont]));
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

        // Creamos los objetos tipo sala recogiendo los datos y los añadimos
        // al inventarioSalas
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

        // Creamos los objetos tipo estanque recogiendo los datos y los añadimos
        // al inventarioEstanques
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

        // Creamos los objetos tipo tiburon recogiendo los datos y los añadimos
        // al inventarioTiburones
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
     * @param clase Letra de la clase en mayúsculas a contar
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
     * Método que lee el fichero pasado por el constructor, busca los objetos
     * que hay y guarda cada atributo de cada objeto en su array
     * @param atributo Atributo de los objetos que quieres
     * @param totalObj Total de objetos que hay en el fichero para definir el array 2d
     * @return String[][] Un array 2d con los atributos de las salas encontradas
     */
    private String[][] getAtributosObj(String atributo, int totalObj) {
        BufferedReader br = null;
        String[][] salas = new String[totalObj][TOTAL_CAMPOS];
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
}
