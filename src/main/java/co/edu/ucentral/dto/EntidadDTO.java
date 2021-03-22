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
public class EntidadDTO {
    private int idEntidad;
    private String NombreEntidad;
    private String email;
    private String descripcion;
    private String direccion;
    private int telefono;

    public EntidadDTO(int idEntidad, String NombreEntidad, String email, String descripcion, String direccion, int telefono) {
        this.idEntidad = idEntidad;
        this.NombreEntidad = NombreEntidad;
        this.email = email;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
    }  

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreEntidad() {
        return NombreEntidad;
    }

    public void setNombreEntidad(String NombreEntidad) {
        this.NombreEntidad = NombreEntidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
