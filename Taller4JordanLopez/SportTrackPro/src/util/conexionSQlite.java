/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQlite {

    private static final String URL = "jdbc:sqlite:sporttrackpro.db";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }
}
