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

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCiudad());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());

            return false;

        }

    }

    public ArrayList<equipo> listar() {

        ArrayList<equipo> lista = new ArrayList<>();

        String sql = "SELECT * FROM equipo";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                equipo e = new equipo();

                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCiudad(rs.getString("ciudad"));

                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return lista;
    }

    public equipo buscarPorId(int id) {

        String sql = "SELECT * FROM equipo WHERE id = ?";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                equipo e = new equipo();

                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCiudad(rs.getString("ciudad"));

                return e;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return null;
    }

    public boolean actualizar(equipo e) {

        String sql = "UPDATE equipo SET nombre=?, ciudad=? WHERE id=?";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCiudad());
            ps.setInt(3, e.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }

    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM equipo WHERE id=?";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }

    }

}
