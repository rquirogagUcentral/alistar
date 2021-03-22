/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.dto;

/**
 *
 * @author Rosemberg
 */
public class HorarioDTO {
    private int idHorario;
    private String hora;
    private String fecha;
    private int disponibilidad;

    public HorarioDTO(int idHorario, String hora, String fecha, int disponibilidad) {
        this.idHorario = idHorario;
        this.hora = hora;
        this.fecha = fecha;
        this.disponibilidad = disponibilidad;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
