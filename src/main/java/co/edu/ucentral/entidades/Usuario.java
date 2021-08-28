package co.edu.ucentral.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numero_identificacion")
	private Integer numeroIdentificacion;
	@Column(name = "direccion",length = 100)
	private String direccion;
	@Column(name = "fecha_nacimiento")
	private Timestamp fechaNacimiento;
	@Column(name = "nombre",length = 60)
	private String nombre;
	@Column(name = "password",length = 60)
	private String password;
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoDocumento",referencedColumnName = "tipo_documento")
	private TiposDocumento tipoDocumento;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "telefono", referencedColumnName = "id_Telefono" )
	private Telefono telefono;
	@Column(name = "email",length = 60)
	private String email;
	@Column(name = "imagen")
	private byte[] imagen;
	
	public Usuario() {
	}
	
	public Usuario(Integer numeroIdentificacion, String direccion, Timestamp fechaNacimiento, String nombre,
			String password, TiposDocumento tipoDocumento, Telefono telefono, String email) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.password = password;
		this.tipoDocumento = tipoDocumento;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TiposDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TiposDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	
	

}