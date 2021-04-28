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
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_direccion")
	private Integer idDireccion;
	@Column(name = "direccion", length = 60)
	private String direccion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;

	public Direccion() {

	}

	public Direccion(Integer idDireccion, String direccion) {
		super();
		this.idDireccion = idDireccion;
		this.direccion = direccion;
	}

	public Direccion(Integer idDireccion, String direccion, Servicio servicio) {
		super();
		this.idDireccion = idDireccion;
		this.direccion = direccion;
		this.servicio = servicio;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
