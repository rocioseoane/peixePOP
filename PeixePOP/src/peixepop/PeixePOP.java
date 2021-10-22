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

/**
 *
 * @author Developer
 */
public class PeixePOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos un String con el nombre del archivo con los datos
        String data = "Datos.txt";

        // Creamos un String con la ruta absoluta del archivo que le pasamos
        String rutaAbsoluta = new File(data).getAbsolutePath();

        // Para ver la ruta del archivo usado para datos descomentar la siguiente línea
        // System.out.println(rutaAbsoluta);
        File archivo = new File(rutaAbsoluta);
        FileReader fr = null;
        BufferedReader br = null;
        boolean finArchivo = false;

        if (archivo.exists()) {
            try {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                while ((strCurrentLine = objReader.readLine()) != null) {
                    System.out.println(strCurrentLine);
                }

            } catch (IOException ioe) {
                System.out.println("Archivo no existe");
                System.exit(0);
            }

        }

    }

}
