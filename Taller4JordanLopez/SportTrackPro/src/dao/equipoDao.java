package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.equipo;
import util.conexionSQlite;

public class equipoDao {

    public boolean guardar(equipo e) {

    String sql = "INSERT INTO equipo(nombre, ciudad) VALUES (?, ?)";

    try (Connection con = conexionSQlite.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, e.getNombre());
        ps.setString(2, e.getCiudad());

        ps.executeUpdate();

        int filas = ps.executeUpdate();

        return filas > 0;

    } catch (SQLException ex) {

        System.out.println("Error al guardar el equipo:: " + ex.getMessage());

        return false;

    }
}

    public ArrayList<equipo> listar() {
        return new ArrayList<>();
    }

    public equipo buscarPorId(int id) {
        return null;
    }

    public boolean actualizar(equipo e) {
        return false;
    }

    public boolean eliminar(int id) {
        return false;
    }

}