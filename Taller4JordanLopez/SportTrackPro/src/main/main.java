/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Jordann
 */
import util.conexionSQlite;
import java.sql.Connection;
import vista.menuPrincipal;

public class main {

    public static void main(String[] args) {
        menuPrincipal menu = new menuPrincipal();
        
        // Llamamos al método para que se ejecute el código
        menu.mostrarMenu();
        Connection conexion = conexionSQlite.conectar();

        if (conexion != null) {
            System.out.println("Todo funciona correctamente.");
        }

    }
}