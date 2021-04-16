package co.edu.ucentral.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279749987754275643L;
	@NotNull(message = "El numero no puede ir vacio")
	private Integer numeroIdentificacion;
	@NotNull(message = "El numero no puede ir vacio")
	private TipoDocumentoDto tipoDocumento;
	@NotNull(message = "El numero no puede ir vacio")
	private String nombre;
	@NotNull(message = "El numero no puede ir vacio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@NotNull(message = "El numero no puede ir vacio")
	private TelefonoDTO telefonos;
	@NotNull(message = "El numero no puede ir vacio")
	private String direccion;
	@NotNull(message = "El numero no puede ir vacio")
	private String password;
	
	
	
	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(Integer numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public TipoDocumentoDto getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoDto tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public TelefonoDTO getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(TelefonoDTO telefonos) {
		this.telefonos = telefonos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
