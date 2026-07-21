package controlador;

import dao.equipoDao;
import modelo.equipo;
import java.util.ArrayList;
public class equipoControl {

    private equipoDao dao = new equipoDao();

    public boolean registrarEquipo(String nombre, String ciudad) {

        equipo e = new equipo();

        e.setNombre(nombre);
        e.setCiudad(ciudad);

        return dao.guardar(e);
        
    }
    public ArrayList<equipo> listarEquipos() {
        return dao.listar();
    }
    
    public equipo buscarEquipo(int id){
    return dao.buscarPorId(id);
}

public boolean actualizarEquipo(int id, String nombre, String ciudad){

    equipo e = new equipo();

    e.setId(id);
    e.setNombre(nombre);
    e.setCiudad(ciudad);

    return dao.actualizar(e);
}

public boolean eliminarEquipo(int id){
    return dao.eliminar(id);
}

}