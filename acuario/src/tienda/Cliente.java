/*
 * 
 */
package tienda;

import java.util.Scanner;
public class Cliente extends Persona {

    public Cliente(String codigo, String nombre, String direcccion, String telefono) {
        super(codigo, nombre, direcccion, telefono);
    }

    //métodos
    /**
     * @param leer parametro de tipo Scanner para leer por teclado
     * @return retornarán un valor booleano según la respuesta a la pregunta
     * para este MPV estos metodos no se utilizarán
     */
    public boolean solicitarFactura(Scanner leer) {
        boolean solicita = false;
        System.out.println("¿Desea solicitar Factura? ");
        String respuesta = leer.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            solicita = true;
        }
        return solicita;
    }

    public boolean solicitarPedido(Scanner leer) {
        boolean solicita = false;
        System.out.println("¿Desea solicitar Pedido? ");
        String respuesta = leer.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            solicita = true;
        }
        return solicita;
    }

    /**
     * En este metodo podemos controlar el cobro y calcular el cambio a devolver
     * para este MPV no lo implementaremos
     * @param importe recibe el importe total de la compra
     */
    public void pagarCompra(Double importe) {
        System.out.println("El total a pagar es " + importe + " euros");

    }

}
