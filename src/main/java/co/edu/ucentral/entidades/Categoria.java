package co.edu.ucentral.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name = "categorias")
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "nombre_categoria",length = 50)
	private String nombreCategoria;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;

	public Categoria() {
		
	}

	public Categoria(Integer idCategoria, String nombreCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}

	public Categoria(Integer idCategoria, String nombreCategoria, Servicio servicio) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.servicio = servicio;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}