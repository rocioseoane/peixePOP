/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

import java.io.File;


/**
 *
 * @author Developer
 */
public class PeixePOP {
    
    
    public static void main(String[] args) {
        // Creamos un String con el nombre del archivo con los datos
        String fichero = "Datos.txt";
      
        // Ruta absoluta del fichero que contiene los datos
        String rutaFichero = new File(fichero).getAbsolutePath();
        
        // Creamos nuestro acuario
        Acuario acuario = new Acuario("PeixePOP", rutaFichero);
        
        acuario.rellenarInventario();
        acuario.mostrarInventario();
        
    }
}
