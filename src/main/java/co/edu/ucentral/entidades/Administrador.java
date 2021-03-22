package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	private String contrasenia;

	private Integer identidad;

	@Id
	private String idusuario;

	private String nombreadmin;

	public Administrador() {
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Integer getIdentidad() {
		return this.identidad;
	}

	public void setIdentidad(Integer identidad) {
		this.identidad = identidad;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombreadmin() {
		return this.nombreadmin;
	}

	public void setNombreadmin(String nombreadmin) {
		this.nombreadmin = nombreadmin;
	}

}