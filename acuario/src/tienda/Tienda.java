/*
 *
 */
package tienda;

import common.ConnDB;

public class Tienda {
    
    // Conector JDBC
        private static ConnDB bbdd=ConnDB.getInstance();
        private static Tienda instanciaUnica=null;
  
    private Tienda(){
    }
    
    public static Tienda getInstance(){
        if (instanciaUnica==null){
            instanciaUnica=new Tienda();
        }
        return instanciaUnica;
    }
    
    // Este método muestra todo lo almacenado en la BBDD
    public void dataDump(){
        System.out.println("\n\n****************************\n\t\t CONTENIDOS BBDD TIENDA");
        System.out.println("\nDATOS DE ARTÍCULOS");
        bbdd.cargaDatos("SELECT * FROM articulos");
        bbdd.mostrarDatosArticulos();
        System.out.println("******************\n");
        System.out.println("\nDATOS DE CLIENTES");
        bbdd.cargaDatos("SELECT * FROM clientes");
        bbdd.mostrarDatosClientes();
        System.out.println("******************\n");
        System.out.println("\nDATOS DE TRABAJADORES");
        bbdd.cargaDatos("SELECT * FROM trabajadores");
        bbdd.mostrarDatosTrabajadores();
        System.out.println("******************\n");
    }
    
    public void test(){
        System.out.println("\n\n****************************\n\t\t TEST TIENDA");
        
        System.out.println("Llega un cliente, un trabajador le atiende y pone 3 artículos en su carrito de compra");
        Cliente c = bbdd.getClienteRandom();
        Trabajador t=bbdd.getTrabajadorRandom();
        
        // Creamos un objeto de tipo pedido y otro de tipo factura
        Pedido p = null;
        Factura f;

        int codCarrito=(int) Math.random();
        Carrito carrito=new Carrito(codCarrito);
        for (int i = 0; i < 3; i++) {
            int cantidad = (int) ((Math.random() * 10) + 1);
            Articulo a=bbdd.getArticuloRandom();
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
