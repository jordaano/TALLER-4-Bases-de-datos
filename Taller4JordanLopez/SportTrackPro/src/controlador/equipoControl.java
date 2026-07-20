package controlador;

import dao.equipoDao;
import modelo.equipo;

public class equipoControl {

    private equipoDao dao = new equipoDao();

    public boolean registrarEquipo(String nombre, String ciudad) {

        equipo e = new equipo();

        e.setNombre(nombre);
        e.setCiudad(ciudad);

        return dao.guardar(e);

    }

}