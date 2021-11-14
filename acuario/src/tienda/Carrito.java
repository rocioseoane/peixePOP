/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;
import java.util.ArrayList;

/**
 * Esta clase tendrá un arraylist de articulos 
 * @author yuda
 */
public class Carrito {
    private  ArrayList<Articulo> carrito;
    private int codigo;

    public Carrito(int codigo) {
        this.carrito = new ArrayList<Articulo>();
        this.codigo = codigo;
    }
    

    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Articulo> carrito) {
        this.carrito = carrito;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void anadirArticulo(Articulo a){
        carrito.add(a);
    }
    
    
    public void quitarArticulo(Articulo a){
        carrito.remove(a);
    }
    
}
