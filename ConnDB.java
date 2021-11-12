package prueba;

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

    /**
     * Crea un objecto para conectarse la base de datos por defecto
     */
    public ConnDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://easybyte.club:2223/peixepop", "jdbc", "peixejdbc@Servo2021*");
            System.out.println("Correcto!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
