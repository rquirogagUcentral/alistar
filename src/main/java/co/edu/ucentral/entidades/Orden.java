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
	@Column(name = "nombre_evento", length = 100)
	private String nombreEvento;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "numero_identificacion")
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "horario", referencedColumnName = "id_horario")
	private Horario horario;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "estado", referencedColumnName = "id_estado")
	private Estado estado;
	@OneToMany(mappedBy = "idEvento",fetch = FetchType.LAZY)
	private List<Evento> evento;
	@Column(name = "precio_total")
	private double precioTotal;
	
	
	
	public Orden() {
	}
	
	
	public Orden(Integer idOrden, String nombreEvento, Usuario usuario, Horario horario, Estado estado,
			List<Evento> evento, double precioTotal) {
		super();
		this.idOrden = idOrden;
		this.nombreEvento = nombreEvento;
		this.usuario = usuario;
		this.horario = horario;
		this.estado = estado;
		this.evento = evento;
		this.precioTotal = precioTotal;
	}


	public Integer getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public List<Evento> getEvento() {
		return evento;
	}
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	
}
