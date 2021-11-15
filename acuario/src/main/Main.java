package main;

import acuario.Acuario;
import tienda.Tienda;

/**
 * Clase deonde se ejecuta el programa
 * @author Angel, Jose, Miguel, Paulo, Rocio, Yudaisy, Gianny, Emilio
 */
public class Main {
    
    public static void main(String[] args) {
        
        try {
            Acuario acuario = new Acuario("PEIXEPOP");
            acuario.test();
            Tienda tienda=Tienda.getInstance();
            tienda.mostrarTodo();
            tienda.test();
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>> No se puede conectar con la base de datos");
        }
    }
}
