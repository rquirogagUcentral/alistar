package co.edu.ucentral.entidades;

import java.util.List;

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
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evento")
	private Integer idEvento;
	@Column(name = "nombre_evento")
	private String nombreEvento;
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "evento")
	private List<Orden> orden;
	@Column(name = "valor_total")
	private double valorTotal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHorario" , referencedColumnName = "id_horario")
	private Horario horario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado", referencedColumnName ="id_estado")
	private Estado estado;

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
	

}
