package co.edu.ucentral.entidades;

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
@Table(name = "Eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evento")
	private Integer idEvento;
	@ManyToOne
	@JoinColumn(name = "orden")
	private Orden orden;
	@Column(name = "valor_total")
	private double valorTotal;
	@Column(name = "cantidad")
	private int cantidad;
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "servicio")
	private Servicio servicio;
	
	
	public Evento() {
		super();
	}
	public Evento(Integer idEvento, Orden orden, double valorTotal, int cantidad, Servicio servicio) {
		super();
		this.idEvento = idEvento;
		this.orden = orden;
		this.valorTotal = valorTotal;
		this.cantidad = cantidad;
		this.servicio = servicio;
	}
	public Integer getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	

}
