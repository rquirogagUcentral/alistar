package co.edu.ucentral.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="permisos")
public class Permiso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id_permiso" )
	private Integer idPermiso;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "numero_identificacion")
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "modulo", referencedColumnName = "id_modulo")
	private Modulo modulo;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "roles", referencedColumnName = "id_rol")
	private Rol roles;
	
	public Permiso() {
		// TODO Auto-generated constructor stub
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public Rol getRoles() {
		return roles;
	}
	public void setRoles(Rol roles) {
		this.roles = roles;
	}
	
	
}
