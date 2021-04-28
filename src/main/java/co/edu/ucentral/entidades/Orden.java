package co.edu.ucentral.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Ordenes")
@Entity
public class Orden implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_orden")
	private Integer idOrden;
	@Column(name = "id_servicio")
	private Integer servicio;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "horario", referencedColumnName = "id_horario")
	private Horario horario;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "estado", referencedColumnName = "id_estado")
	private Estado estado;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn()
	private List<Evento> evento;
	@Column(name = "valor_total")
	private double valorTotal;
	
	
	public Orden() {
		
	}


	public Integer getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}


	public Integer getServicio() {
		return servicio;
	}


	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}


	public Horario getHorario() {
		return horario;
	}


	public void setHorario(Horario horario) {
		this.horario = horario;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public List<Evento> getEvento() {
		return evento;
	}


	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}


	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", servicio=" + servicio + ", horario=" + horario + ", estado=" + estado
				+ ", valorTotal=" + valorTotal + "]";
	}
	
	
}
