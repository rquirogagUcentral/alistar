package co.edu.ucentral.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.ucentral.entidades.TiposDocumento;

public class UsuarioDTO {

	private BCryptPasswordEncoder encoder;
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
	private String telefono;
	@NotNull(message = "El numero no puede ir vacio")
	private String direccion;
	@NotNull(message = "El numero no puede ir vacio")
	private String password;
	@NotEmpty(message = "email")
	private String email;
	private byte[] imagen;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO( Integer numeroIdentificacion,
			 TiposDocumento tipoDocumento,
			 String nombre,
			Date fechaNacimiento,
			 String telefono,
			 String direccion,
			 String password,
			String email) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.password = password;
		this.email = email;
	}

	public UsuarioDTO( Integer numeroIdentificacion,
			 TiposDocumento tipoDocumento,
			 String nombre,
			Date fechaNacimiento,
			 String telefono,
			 String direccion,
			 String password,
			String email, byte[] imagen) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.password = password;
		this.email = email;
		this.imagen = imagen;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		
		return  password;
	}

	public void setPassword(String password) {
		encoder =new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	

}
