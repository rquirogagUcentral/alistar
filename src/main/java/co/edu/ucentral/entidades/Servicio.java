package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServicioPK id;

	private String direccion;

	private String nombreservicio;

	private Integer valorunitario;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Entidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="identidad", insertable = false, updatable = false)
	private Entidad entidad;

	public Servicio() {
	}

	public ServicioPK getId() {
		return this.id;
	}

	public void setId(ServicioPK id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreservicio() {
		return this.nombreservicio;
	}

	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	public Integer getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(Integer valorunitario) {
		this.valorunitario = valorunitario;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

}