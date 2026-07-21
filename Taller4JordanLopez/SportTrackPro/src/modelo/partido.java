/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jordann
 */
public class partido {
    private int id;
    private int idEquipoLocal;
    private int idEquipoRival;
    private String fecha;
    private int idSede;
    private int idArbitro;
    private int golesLocal;
    private int golesRival;
    private int ganador;
    public partido() {
}
    public partido(int id, int idEquipoLocal, int idEquipoRival, String fecha, int idSede, int idArbitro, int golesLocal, int golesRival, int ganador) {
        this.id = id;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoRival = idEquipoRival;
        this.fecha = fecha;
        this.idSede = idSede;
        this.idArbitro = idArbitro;
        this.golesLocal = golesLocal;
        this.golesRival = golesRival;
        this.ganador = ganador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public int getIdEquipoRival() {
        return idEquipoRival;
    }

    public void setIdEquipoRival(int idEquipoRival) {
        this.idEquipoRival = idEquipoRival;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesRival() {
        return golesRival;
    }

    public void setGolesRival(int golesRival) {
        this.golesRival = golesRival;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    
}
