/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Rosemberg
 */
public class Administrador {
    private String idUsuario;
    private int idEntidad;
    private String nombreAdmin;
    private String Contrasenia;

    public Administrador(String idUsuario, int idEntidad, String nombreAdmin, String Contrasenia) {
        this.idUsuario = idUsuario;
        this.idEntidad = idEntidad;
        this.nombreAdmin = nombreAdmin;
        this.Contrasenia = Contrasenia;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }
}
