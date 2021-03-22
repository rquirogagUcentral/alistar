/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.dto;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Rosemberg
 */
public class AdministradorDTO {
	@NotNull
	private String idUsuario;
	@NotNull
	private int idEntidad;
	@NotNull
	private String nombreAdmin;
	@NotNull
	private String Contrasenia;

	public AdministradorDTO(String idUsuario, int idEntidad, String nombreAdmin, String Contrasenia) {
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
