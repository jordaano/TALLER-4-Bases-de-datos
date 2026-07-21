package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.jugador;
import util.conexionSQlite;

public class jugadorDao {

    public boolean guardar(jugador j) {

        String sql = "INSERT INTO jugador(nombre,edad,posicion,idEquipo) VALUES(?,?,?,?)";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, j.getNombre());
            ps.setInt(2, j.getEdad());
            ps.setString(3, j.getPosicion());
            ps.setInt(4, j.getIdEquipo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<jugador> listar() {

        ArrayList<jugador> lista = new ArrayList<>();

        String sql = "SELECT * FROM jugador";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                jugador j = new jugador();

                j.setId(rs.getInt("id"));
                j.setNombre(rs.getString("nombre"));
                j.setEdad(rs.getInt("edad"));
                j.setPosicion(rs.getString("posicion"));
                j.setIdEquipo(rs.getInt("idEquipo"));

                lista.add(j);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }

    public ArrayList<jugador> listarPorEquipo(int idEquipo) {

        ArrayList<jugador> lista = new ArrayList<>();

        String sql = "SELECT * FROM jugador WHERE idEquipo=?";

        try (Connection con = conexionSQlite.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEquipo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jugador j = new jugador();

                j.setId(rs.getInt("id"));
                j.setNombre(rs.getString("nombre"));
                j.setEdad(rs.getInt("edad"));
                j.setPosicion(rs.getString("posicion"));
                j.setIdEquipo(rs.getInt("idEquipo"));

                lista.add(j);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }

}
