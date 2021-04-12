package co.edu.ucentral.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279749987754275643L;
	private Integer numeroIdentificacion;
	private TipoDocumentoDto tipoDocumento;
	private String nombre;
	private Date fechaNacimiento;
	private TelefonoDTo telefonos;
	private String direccion;
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
	public TelefonoDTo getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(TelefonoDTo telefonos) {
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
