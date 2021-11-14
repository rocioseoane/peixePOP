
package tienda;

import java.util.ArrayList;
import tienda.articulos.*;

public class GestionArticulos {

    ArrayList<Articulo> listaArticulos = new ArrayList();

    /*
    *Esta clase es un ejemplo de lo que podemos hacer para getsionar los datos
    *para este MPV no esta implementada
    *solo hemos creado el arrayList de articulos y lo hemos llenado a mano
    *devolviendo al main la lista de articulos, pero en un futuro seria oportuno
    *tener una clase que gestione los articulos, los clientes y trabajadores    
     */
    public ArrayList<Articulo> darAlta() {

        Articulo a1 = new AnimalAcuatico("codarticulo001", "GoldFish", 100, 5.00);
        Articulo a2 = new AnimalAcuatico("codarticulo002", "Anubia común", 200, 15.00);
        Articulo a3 = new Alimento("codarticulo003", "Alimento en escamas", 300, 25.00);
        Articulo a4 = new Accesorio("codarticulo004", "Oxigenador", 400, 35.00);
        Articulo a5 = new Pecera("codarticulo005", " Pecera 120 litros", 0, 95.00);
        Articulo a6 = new Pecera("codarticulo006", " Pecera 20 litros", 0, 50.00);

        listaArticulos.add(a1);
        listaArticulos.add(a2);
        listaArticulos.add(a3);
        listaArticulos.add(a4);
        listaArticulos.add(a5);
        listaArticulos.add(a6);

        return listaArticulos;
    }

}
