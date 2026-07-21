package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQlite {

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            
            // Ruta exacta a tu archivo .db en el equipo (usa slashes /)
            String url = "jdbc:sqlite:db/sporttrack.db";
            System.out.println(url);

            con = DriverManager.getConnection(url);
            // System.out.println("Conexión exitosa.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }
}