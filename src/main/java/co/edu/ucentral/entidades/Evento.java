package co.edu.ucentral.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name = "Eventos")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1044411635563229957L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evento")
	private Integer idEvento;
	@Column(name = "nombre_evento")
	private String nombreEvento;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "evento")
	private List<Orden> orden;
	@Column(name = "valor_total")
	private double valorTotal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHorario", referencedColumnName = "id_horario")
	private Horario horario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado", referencedColumnName = "id_estado")
	private Estado estado;

	public Evento() {
		orden = new ArrayList<Orden>();
	}
	

	public Evento(Integer idEvento, String nombreEvento, List<Orden> orden, double valorTotal, Horario horario,
			Usuario usuario, Estado estado) {
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.orden = orden;
		this.valorTotal = valorTotal;
		this.horario = horario;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public List<Orden> getOrden() {
		return orden;
	}

	public void setOrden(List<Orden> orden) {
		this.orden = orden;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

}
