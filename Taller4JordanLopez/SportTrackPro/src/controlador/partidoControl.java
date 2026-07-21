package controlador;

import dao.partidoDao;
import java.util.ArrayList;
import modelo.equipo;
import modelo.partido;

public class partidoControl {

    private partidoDao dao = new partidoDao();

    public boolean registrarPartido(int local,
            int rival,
            String fecha,
            int sede,
            int arbitro) {

        partido p = new partido();

        p.setIdEquipoLocal(local);
        p.setIdEquipoRival(rival);
        p.setFecha(fecha);
        p.setIdSede(sede);
        p.setIdArbitro(arbitro);

        p.setGolesLocal(0);
        p.setGolesRival(0);
        p.setGanador(0);

        return dao.guardar(p);

    }

    public ArrayList<partido> listarPartidos() {

        return dao.listar();

    }

    public boolean registrarResultado(int idPartido,
            int golesLocal,
            int golesRival,
            int idEquipoLocal,
            int idEquipoRival) {

        int ganador;

        if (golesLocal > golesRival) {

            ganador = idEquipoLocal;

        } else if (golesRival > golesLocal) {

            ganador = idEquipoRival;

        } else {

            ganador = 0; // empate

        }

        return dao.registrarResultado(idPartido,
                golesLocal,
                golesRival,
                ganador);

    }

    public partido buscarPartido(int id) {

        return dao.buscarPorId(id);

    }

    public void historialEquipo(int idEquipo) {

        dao.historialEquipo(idEquipo);

    }

    public void tablaPosiciones() {

        equipoControl ec = new equipoControl();

        ArrayList<equipo> equipos = ec.listarEquipos();

        ArrayList<partido> partidos = dao.listar();

        System.out.println("\n================ TABLA DE POSICIONES ================\n");

        System.out.printf("%-15s %3s %3s %3s %3s %3s %3s %4s\n",
                "Equipo", "PJ", "PG", "PE", "PP", "GF", "GC", "PTS");

        for (equipo e : equipos) {

            int pj = 0;
            int pg = 0;
            int pe = 0;
            int pp = 0;
            int gf = 0;
            int gc = 0;
            int pts = 0;

            for (partido p : partidos) {

                if (p.getIdEquipoLocal() == e.getId()) {

                    pj++;

                    gf += p.getGolesLocal();
                    gc += p.getGolesRival();

                    if (p.getGanador() == e.getId()) {

                        pg++;
                        pts += 3;

                    } else if (p.getGanador() == 0) {

                        pe++;
                        pts++;

                    } else {

                        pp++;

                    }

                } else if (p.getIdEquipoRival() == e.getId()) {

                    pj++;

                    gf += p.getGolesRival();
                    gc += p.getGolesLocal();

                    if (p.getGanador() == e.getId()) {

                        pg++;
                        pts += 3;

                    } else if (p.getGanador() == 0) {

                        pe++;
                        pts++;

                    } else {

                        pp++;

                    }

                }

            }

            System.out.printf("%-15s %3d %3d %3d %3d %3d %3d %4d\n",
                    e.getNombre(),
                    pj,
                    pg,
                    pe,
                    pp,
                    gf,
                    gc,
                    pts);

        }

    }
}
