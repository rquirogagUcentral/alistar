package co.edu.ucentral.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import co.edu.ucentral.entidades.Telefono;
import co.edu.ucentral.entidades.TiposDocumento;
public class UsuarioDTO {

	
	@NotNull(message = "El numero no puede ir vacio")
	private Integer numeroIdentificacion;
	@NotNull(message = "El numero no puede ir vacio")
	private TiposDocumento tipoDocumento;
	@NotNull(message = "El numero no puede ir vacio")
	private String nombre;
	@NotNull(message = "El numero no puede ir vacio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@NotNull(message = "El numero no puede ir vacio")
	private Telefono telefono;
	@NotNull(message = "El numero no puede ir vacio")
	private String direccion;
	@NotNull(message = "El numero no puede ir vacio")
	private String password;
	@NotEmpty(message = "email")
	private String email;
	
	public UsuarioDTO() {
		
	}
	
	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(Integer numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public TiposDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TiposDocumento tipoDocumento) {
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
	public Telefono getTelefonos() {
		return telefono;
	}
	public void setTelefonos(Telefono telefonos) {
		this.telefono = telefonos;
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

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
