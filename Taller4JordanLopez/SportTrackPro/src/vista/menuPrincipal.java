package vista;

import controlador.equipoControl;
import java.util.Scanner;

public class menuPrincipal {

    // These can stay as class attributes
    Scanner sc = new Scanner(System.in);
    equipoControl control = new equipoControl();

    // All executable logic goes inside this method
    public void mostrarMenu() {
        System.out.println("=== REGISTRAR EQUIPO ===");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();

        if (control.registrarEquipo(nombre, ciudad)) {
            System.out.println("Equipo registrado correctamente.");
        } else {
            System.out.println("Error al registrar el equipo.");
        }
    }
}