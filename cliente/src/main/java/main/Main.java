package main;
import common.APIConfig;
import common.APIRequest;
import common.ConnDB;

/**
 * Clase deonde se ejecuta el programa
 * @author Angel, Jose, Miguel, Paulo, Rocio, Yudaisy, Gianny, Emilio
 */
public class Main {

    public static void main(String[] args)  {
        int count = 0;
        float totalMs = 0;
        APIRequest apiRequest = new APIRequest();
        System.out.println("---- Server API REST Elapsed time (20 x getClientes)----");
        while(true) {
            count++;
            // All query
            long start2 = System.currentTimeMillis();
            apiRequest.getClientes();
            long end2 = System.currentTimeMillis();
            System.out.print(". ");
            //System.out.println("getSalas - Elapsed time: "+(end2-start2)+"ms");
            totalMs += (end2-start2);
            if(count>20) { break; }
        }
        System.out.print("Total: "+totalMs/1000+" | Media: ");
        System.out.format("%.2f%n", (totalMs/count)/1000);

        totalMs=0;
        count=0;
        ConnDB con = new ConnDB();
        System.out.println("---- ConnDB Elapsed time (20 x getClientes)----");
        while(true) {
            count++;
            long start2 = System.currentTimeMillis();
            con.getClientes();
            long end2 = System.currentTimeMillis();
            System.out.print(". ");
            totalMs += (end2-start2);
            if(count>20) { break; }
        }
        System.out.print("Total: "+totalMs/1000+" | Media: ");
        System.out.format("%.2f%n", (totalMs/count)/1000);
        /*try {
            Acuario acuario = new Acuario("PEIXEPOP");
            acuario.test();
            Tienda tienda=Tienda.getInstance();
            tienda.mostrarTodo();
            tienda.test();
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>> No se puede conectar con la base de datos");
        }*/
    }
}
