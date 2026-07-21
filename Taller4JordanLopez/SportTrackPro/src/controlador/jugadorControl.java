package controlador;

import dao.jugadorDao;
import java.util.ArrayList;
import modelo.jugador;

public class jugadorControl {

    private jugadorDao dao = new jugadorDao();

    public boolean registrarJugador(String nombre, int edad, String posicion, int idEquipo) {

        jugador j = new jugador();

        j.setNombre(nombre);
        j.setEdad(edad);
        j.setPosicion(posicion);
        j.setIdEquipo(idEquipo);

        return dao.guardar(j);
    }

    public ArrayList<jugador> listarJugadores() {
        return dao.listar();
    }
    public ArrayList<jugador> listarPorEquipo(int idEquipo){

    return dao.listarPorEquipo(idEquipo);

}
}