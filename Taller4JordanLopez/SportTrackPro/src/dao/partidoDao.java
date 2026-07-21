package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.partido;
import util.conexionSQlite;

public class partidoDao {

    public boolean guardar(partido p){

        String sql = "INSERT INTO tablaPartido(idEquipoLocal,idEquipoRival,fecha,idSede,idArbitro,golesLocal,golesRival,ganador) VALUES(?,?,?,?,?,?,?,?)";

        try(Connection con = conexionSQlite.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,p.getIdEquipoLocal());
            ps.setInt(2,p.getIdEquipoRival());
            ps.setString(3,p.getFecha());
            ps.setInt(4,p.getIdSede());
            ps.setInt(5,p.getIdArbitro());
            ps.setInt(6,p.getGolesLocal());
            ps.setInt(7,p.getGolesRival());
            ps.setInt(8,p.getGanador());

            return ps.executeUpdate()>0;

        }catch(SQLException e){

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<partido> listar(){

        ArrayList<partido> lista = new ArrayList<>();

        String sql="SELECT * FROM tablaPartido";

        try(Connection con = conexionSQlite.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                partido p = new partido();

                p.setId(rs.getInt("id"));
                p.setIdEquipoLocal(rs.getInt("idEquipoLocal"));
                p.setIdEquipoRival(rs.getInt("idEquipoRival"));
                p.setFecha(rs.getString("fecha"));
                p.setIdSede(rs.getInt("idSede"));
                p.setIdArbitro(rs.getInt("idArbitro"));
                p.setGolesLocal(rs.getInt("golesLocal"));
                p.setGolesRival(rs.getInt("golesRival"));
                p.setGanador(rs.getInt("ganador"));

                lista.add(p);

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

        return lista;

    }
    public boolean registrarResultado(int idPartido, int golesLocal, int golesRival, int ganador) {

    String sql = "UPDATE tablaPartido SET golesLocal=?, golesRival=?, ganador=? WHERE id=?";

    try (Connection con = conexionSQlite.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, golesLocal);
        ps.setInt(2, golesRival);
        ps.setInt(3, ganador);
        ps.setInt(4, idPartido);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

        return false;

    }

}
    public partido buscarPorId(int id){

    String sql="SELECT * FROM tablaPartido WHERE id=?";

    try(Connection con = conexionSQlite.conectar();
        PreparedStatement ps = con.prepareStatement(sql)){

        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            partido p = new partido();

            p.setId(rs.getInt("id"));
            p.setIdEquipoLocal(rs.getInt("idEquipoLocal"));
            p.setIdEquipoRival(rs.getInt("idEquipoRival"));
            p.setFecha(rs.getString("fecha"));
            p.setIdSede(rs.getInt("idSede"));
            p.setIdArbitro(rs.getInt("idArbitro"));
            p.setGolesLocal(rs.getInt("golesLocal"));
            p.setGolesRival(rs.getInt("golesRival"));
            p.setGanador(rs.getInt("ganador"));

            return p;

        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return null;

}
    public void historialEquipo(int idEquipo) {

    String sql = """
        SELECT
            p.id,
            e1.nombre AS local,
            e2.nombre AS visitante,
            p.fecha,
            p.golesLocal,
            p.golesRival
        FROM tablaPartido p
        INNER JOIN equipo e1 ON p.idEquipoLocal = e1.id
        INNER JOIN equipo e2 ON p.idEquipoRival = e2.id
        WHERE p.idEquipoLocal = ? OR p.idEquipoRival = ?
        ORDER BY p.fecha;
        """;

    try (Connection con = conexionSQlite.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idEquipo);
        ps.setInt(2, idEquipo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println("--------------------------------");
            System.out.println("Partido: " + rs.getInt("id"));
            System.out.println(rs.getString("local")
                    + " "
                    + rs.getInt("golesLocal")
                    + " - "
                    + rs.getInt("golesRival")
                    + " "
                    + rs.getString("visitante"));

            System.out.println("Fecha: " + rs.getString("fecha"));
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}
}