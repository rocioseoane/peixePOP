/*
 *
 */
package tienda;

import common.ConnDB;
import java.util.ArrayList;

public class Tienda {
  
    public Tienda() {
        // Instanciación conector JDBC
        ConnDB bbdd=ConnDB.getInstance();
        // Preparamos estructuras de datos
        System.out.println("Cargando datos de la BBDD...");
        ArrayList<Trabajador> listaTrabajadores = bbdd.getTrabajadores();
        ArrayList<Cliente> listaClientes = bbdd.getClientes();
        ArrayList<Articulo> listaArticulos = bbdd.getArticulos();
        System.out.println("Lista de artículos cargada");
        // Creamos un objeto de tipo pedido y otro de tipo factura
        Pedido p = null;
        Factura f;

//  EL CODIGO COMENTADO A CONTINUACIÓN PERTENECE A LA PRIMERA FASE DEL MPV
//  EN LA SEGUNDA FASE (INTEGRACIÓN) ES INNECESARIO YA QUE LOS DATOS SE OBTIENEN
//  DE UNA BBDD A TRAVÉS DE UN CONECTOR JDBC
//
//        System.out.println("Creamos cuatro clientes de ejemplo");
//        Cliente c1 = new Cliente("codcliente001", "Juan", "A Coruña", "6666666666");
//        Cliente c2 = new Cliente("codcliente002", "Marcos", "Lugo", "777777777");
//        Cliente c3 = new Cliente("codcliente003", "Lucas", "Ourense", "8888888888");
//        Cliente c4 = new Cliente("codcliente004", "Mateo", "Pontevedra", "9999999999");
//        System.out.println("Estos clientes se dan de alta en el sistema (se almacenan)");
//
//        listaClientes.add(c1);
//        listaClientes.add(c2);
//        listaClientes.add(c3);
//        listaClientes.add(c4);
//       
//        System.out.println("Creamos tres trabajador y lo registramos");
//        Trabajador t1 = new Trabajador("codtrabajador001", "Herodes", "Jerusalen", "000000000",1000.00);
//        Trabajador t2 = new Trabajador("codtrabajador002", "Juan", "Madrid", "111111111",1000.00);
//        Trabajador t3 = new Trabajador("codtrabajador003", "Pedro", "Valencia", "22222222", 1000.00);
//
//        listaTrabajadores.add(t1);
//        listaTrabajadores.add(t2);
//        listaTrabajadores.add(t3);
//        System.out.println("Creamos y registramos 6 artículos distintos");
//
//        GestionArticulos gestor = new GestionArticulos();
//        listaArticulos = gestor.darAlta();
//        System.out.println("****************************************\n");

     
        System.out.println("Llega un cliente, un trabajador le atiende y pone 3 artículos en su carrito de compra");

        //obtenemos un cliente aleatorio de mi lista de clientes 
        int indexc = (int) (Math.random() * listaClientes.size());
        Cliente c = listaClientes.get(indexc);

        //obtenemos un trabajador aleatorio de mi lista de trabajadores 
        int indext = (int) (Math.random() * listaTrabajadores.size());
        Trabajador t = listaTrabajadores.get(indext);

        /*Añadimos artículos de forma aleatoria en el carrito de compra
        *En el futuro podemos hacer una clase de tipo carrito de compra
        *con metdos añadir, quitar articulo
        *
        *******************************************************/
        int codCarrito=(int) Math.random();
        Carrito carrito=new Carrito(codCarrito);
        for (int i = 0; i < 3; i++) {
            int indexA = (int) (Math.random() * listaArticulos.size());
            int cantidad = (int) ((Math.random() * 10) + 1);
            Articulo a = listaArticulos.get(indexA);

            //comprobemos que hay suficiente stck
            if (a.getStock() == 0) {
                //evaluamos si aún no hemos creado un pedido, llamamos al método generarPedido y se lo asignamos a nuestro objeto p
                if (p == null) {
                    p = t.generarPedido();
                }
                // luego llamamos al método añadirLinea pasándole como parámetros el artículo y la cantidad 
                p.añadirLinea(a, cantidad);
            } else {
                //si hay stock lo añado al carrito
                carrito.anadirArticulo(a);
            }

        }
        System.out.println("****************************************\n");
        System.out.println("Para proceder a la venta, obtenemos el precio de cada articulo del carrito y pagamos");
        double importeTotal = 0;
        //recorremos el carrito con un foreach y acuamulamos el precio de cada articulo
        for (Articulo a : carrito.getCarrito()) {
            importeTotal += a.getPrecio();
        }
        //llamamos al metodo pagarCompra() del objeto cliente
        c.pagarCompra(importeTotal);
        System.out.println("************************************************");

        System.out.println("Suponemos que el cliente quiere una factura");
        //llamamos al metodo generarFactura de nuestro objeto trabajdor 
        f = t.generarFactura(c, importeTotal);
        System.out.println("Fecha de la factura: " + f.getFecha());
        LineaFactura lf;
        /*recorremos el carrito creando una lineaFactura con los datos de cada articulo 
        *y lo añadimos a nuestra factura
         */
        for (Articulo a : carrito.getCarrito()) {
            System.out.println(a.getDescripcion() + " - " + a.getPrecio());
            lf = new LineaFactura(1, a.getDescripcion(), a.getPrecio());
            f.añadirLinea(lf);
        }
        
        System.out.println("IMPRIMIMOS FACTURA EN FICHERO");
        f.imprimir();
           
    }

}
