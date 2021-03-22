package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
@NamedQuery(name="Tipousuario.findAll", query="SELECT t FROM Tipousuario t")
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tipousuario;

	private String nombretipousuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipousuarioBean")
	private List<Usuario> usuarios;

	public Tipousuario() {
	}

	public Integer getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Integer tipousuario) {
		this.tipousuario = tipousuario;
	}

	public String getNombretipousuario() {
		return this.nombretipousuario;
	}

	public void setNombretipousuario(String nombretipousuario) {
		this.nombretipousuario = nombretipousuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipousuarioBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipousuarioBean(null);

		return usuario;
	}

}