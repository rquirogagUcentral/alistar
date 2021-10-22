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

@Table(name = "Ordenes")
@Entity
public class Orden implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_orden")
	private Integer idOrden;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "total_orden")
	private double totalOrden;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evento")
	private Evento evento;

	public Orden() {
		
	}

	public Orden(Integer idOrden, Servicio servicio, int cantidad, double totalOrden, Evento evento) {
		super();
		this.idOrden = idOrden;
		this.servicio = servicio;
		this.cantidad = cantidad;
		this.totalOrden = totalOrden;
		this.evento = evento;
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotalOrden() {
		return totalOrden;
	}

	public void setTotalOrden(double totalOrden) {
		this.totalOrden = totalOrden;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
