package vista;

import controlador.equipoControl;
import java.util.Scanner;
import modelo.equipo;
import controlador.jugadorControl;
import controlador.partidoControl;
import modelo.jugador;
import modelo.partido;

public class menuPrincipal {

    Scanner sc = new Scanner(System.in);

    equipoControl control = new equipoControl();
    jugadorControl controlJugador = new jugadorControl();
    partidoControl controlPartido = new partidoControl();

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("\n========= SPORTTRACK PRO =========");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Listar equipos");
            System.out.println("3. Buscar equipo");
            System.out.println("4. Actualizar equipo");
            System.out.println("5. Eliminar equipo");
            System.out.println("6. Registrar jugador");
            System.out.println("7. Listar jugadores");
            System.out.println("8. Listar jugadores por equipo");
            System.out.println("9. Registrar resultado");
            System.out.println("10. Historial de un equipo");
            System.out.println("11. Tabla de posiciones");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre del equipo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ciudad: ");
                    String ciudad = sc.nextLine();

                    if (control.registrarEquipo(nombre, ciudad)) {
                        System.out.println("Equipo registrado correctamente.");
                    } else {
                        System.out.println("Error al registrar.");
                    }

                    break;

                case 2:

                    System.out.println("\n===== EQUIPOS =====");

                    for (equipo e : control.listarEquipos()) {

                        System.out.println(
                                e.getId()
                                + " - "
                                + e.getNombre()
                                + " - "
                                + e.getCiudad());

                    }

                    break;

                case 3:

                    System.out.print("Ingrese el ID: ");

                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    equipo eq = control.buscarEquipo(idBuscar);

                    if (eq != null) {

                        System.out.println("ID: " + eq.getId());
                        System.out.println("Nombre: " + eq.getNombre());
                        System.out.println("Ciudad: " + eq.getCiudad());

                    } else {

                        System.out.println("Equipo no encontrado.");

                    }

                    break;

                case 4:

                    System.out.print("ID del equipo: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nueva ciudad: ");
                    String nuevaCiudad = sc.nextLine();

                    if (control.actualizarEquipo(id, nuevoNombre, nuevaCiudad)) {

                        System.out.println("Equipo actualizado.");

                    } else {

                        System.out.println("No se pudo actualizar.");

                    }

                    break;

                case 5:

                    System.out.print("ID del equipo: ");

                    int eliminar = sc.nextInt();

                    if (control.eliminarEquipo(eliminar)) {

                        System.out.println("Equipo eliminado.");

                    } else {

                        System.out.println("No existe ese equipo.");

                    }

                    break;

                case 6:

                    System.out.println("\n===== REGISTRAR JUGADOR =====");

                    System.out.println("Equipos disponibles:");

                    for (equipo e : control.listarEquipos()) {

                        System.out.println(
                                e.getId() + " - "
                                + e.getNombre());

                    }

                    System.out.print("Nombre: ");
                    String nombreJugador = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Posición: ");
                    String posicion = sc.nextLine();

                    System.out.print("ID del equipo: ");
                    int idEquipo = sc.nextInt();
                    sc.nextLine();

                    if (controlJugador.registrarJugador(nombreJugador, edad, posicion, idEquipo)) {

                        System.out.println("Jugador registrado correctamente.");

                    } else {

                        System.out.println("Error al registrar jugador.");

                    }

                    break;
                case 7:

                    System.out.println("\n===== LISTA DE JUGADORES =====");

                    for (jugador j : controlJugador.listarJugadores()) {

                        System.out.println(
                                "ID: " + j.getId()
                                + " | Nombre: " + j.getNombre()
                                + " | Edad: " + j.getEdad()
                                + " | Posición: " + j.getPosicion()
                                + " | Equipo: " + j.getIdEquipo());

                    }

                    break;
                case 8:

                    System.out.println("\n===== EQUIPOS =====");

                    for (equipo e : control.listarEquipos()) {

                        System.out.println(e.getId() + " - " + e.getNombre());

                    }

                    System.out.print("Seleccione el ID del equipo: ");

                    int idEquipoBuscar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n===== JUGADORES =====");

                    for (jugador j : controlJugador.listarPorEquipo(idEquipoBuscar)) {

                        System.out.println(
                                j.getId()
                                + " - "
                                + j.getNombre()
                                + " - "
                                + j.getPosicion());

                    }

                    break;
                case 9:

                    System.out.println("\n===== PARTIDOS =====");

                    for (partido p : controlPartido.listarPartidos()) {

                        System.out.println(
                                p.getId()
                                + " | Local: " + p.getIdEquipoLocal()
                                + " | Rival: " + p.getIdEquipoRival()
                                + " | Fecha: " + p.getFecha());

                    }

                    System.out.print("ID del partido: ");

                    int idPartido = sc.nextInt();

                    partido p = controlPartido.buscarPartido(idPartido);

                    if (p == null) {

                        System.out.println("Partido no encontrado.");

                        break;

                    }

                    System.out.print("Goles local: ");

                    int gl = sc.nextInt();

                    System.out.print("Goles rival: ");

                    int gr = sc.nextInt();

                    if (controlPartido.registrarResultado(idPartido,
                            gl,
                            gr,
                            p.getIdEquipoLocal(),
                            p.getIdEquipoRival())) {

                        System.out.println("Resultado registrado.");

                    } else {

                        System.out.println("No se pudo registrar.");

                    }

                    break;
                case 10:

                    System.out.println("\n===== EQUIPOS =====");

                    for (equipo e : control.listarEquipos()) {

                        System.out.println(e.getId() + " - " + e.getNombre());

                    }

                    System.out.print("Seleccione el ID del equipo: ");

                    int idHistorial = sc.nextInt();

                    controlPartido.historialEquipo(idHistorial);

                    break;
                case 11:

                    controlPartido.tablaPosiciones();

                    break;
                case 0:

                    System.out.println("Hasta luego.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }
}
