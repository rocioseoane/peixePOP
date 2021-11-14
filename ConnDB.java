package peixepop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clase principal para conectarse a la base de datos
 *
 * @author angel
 */
public class ConnDB {

    // Atributos
    public Connection conn;
    private ResultSet rs;

    /**
     * Constructor para conectarse la base de datos por defecto
     */
    public ConnDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://easybyte.club:2223/peixepop", "jdbc", "peixejdbc@Servo2021*");
            System.out.println("Conectado a la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hace una consulta a la base de datos y se guarda en el ResultSet
     * @param query Hacer una consulta a la base de datos
     */
    public void cargaDatos(String query) {
        Statement stmt = null;

        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla articulos
     */
    public void mostrarDatosArticulos() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String descripcion = rs.getString("descripcion");
                String stock = rs.getString("stock");
                String precio = rs.getString("precio");
                String tipoArticulo = rs.getString("tipo_articulo");
                System.out.println(codigo + "," + descripcion + "," + stock + "," + precio + "," + tipoArticulo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla clientes
     */
    public void mostrarDatosClientes() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                System.out.println(codigo + "," + nombre + "," + direccion + "," + telefono);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla estanques
     */
    public void mostrarDatosEstanques() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String tipo = rs.getString("tipo");
                String nombre = rs.getString("nombre");
                String codigoSala = rs.getString("codigo_sala");
                System.out.println(codigo + "," + tipo + "," + nombre + "," + codigoSala);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // TODO: Falta hacer enseñar las tablas: factura, lineas_facturas y 
    // lineas pedidos por falta de datos
    
    /**
     * Muestra los datos de la tabla plantas
     */
    public void mostrarDatosPlantas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String medioDeVida = rs.getString("medio_de_vida");
                String nombre = rs.getString("nombre");
                String codigoEstanque = rs.getString("codigo_estanque");
                String codigoSala = rs.getString("codigo_sala");
                System.out.println(codigo + "," + medioDeVida + "," + nombre + "," + codigoEstanque + "," + codigoSala);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla salas
     */
    public void mostrarDatosSalas() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                System.out.println(codigo + "," + nombre + "," + tipo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla tiburones
     */
    public void mostrarDatosTiburones() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String tamano = rs.getString("tamano");
                String codigoEstanque = rs.getString("codigo_estanque");
                System.out.println(codigo + "," + nombre + "," + tamano + "," + codigoEstanque);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Muestra los datos de la tabla trabajadores
     */
    public void mostrarDatosTrabajadores() {
        try {
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String salario = rs.getString("salario");
                System.out.println(codigo + "," + nombre + "," + direccion + "," + telefono + "," + salario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
