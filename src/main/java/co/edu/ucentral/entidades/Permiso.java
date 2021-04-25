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
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id_permiso" )
	private Integer idPermiso;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "numero_identificacion" )
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoRol", referencedColumnName = "id_rol" )
	private Rol tipoRol;
	
	
	public Permiso() {
		// TODO Auto-generated constructor stub
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Rol getTipoRol() {
		return tipoRol;
	}
	public void setTipoRol(Rol tipoRol) {
		this.tipoRol = tipoRol;
	}

	
}
