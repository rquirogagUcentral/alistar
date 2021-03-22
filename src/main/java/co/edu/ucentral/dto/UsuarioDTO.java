/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.dto;

/**
Rosemberg
 */
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private int tipoUsuario;
    private String dirección;
    private String fechaNacimiento;
    private TelefonoDTO telefono;

    public UsuarioDTO(int idUsuario, String nombreUsuario, String email, int tipoUsuario, String dirección, String fechaNacimiento, TelefonoDTO telefono) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.dirección = dirección;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TelefonoDTO getTelefono() {
        return telefono;
    }

    public void setTelefono(TelefonoDTO telefono) {
        this.telefono = telefono;
    }
    
}
