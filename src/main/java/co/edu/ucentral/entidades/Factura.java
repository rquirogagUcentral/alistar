package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FacturaPK id;

	private Integer autorizacion;

	private String estado;

	private Integer valortotal;

	//bi-directional many-to-one association to Evento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idevento", insertable = false, updatable = false)
	private Evento evento;

	//bi-directional many-to-one association to Orden
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idorden")
	private Orden orden;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Factura() {
	}

	public FacturaPK getId() {
		return this.id;
	}

	public void setId(FacturaPK id) {
		this.id = id;
	}

	public Integer getAutorizacion() {
		return this.autorizacion;
	}

	public void setAutorizacion(Integer autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(Integer valortotal) {
		this.valortotal = valortotal;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Orden getOrden() {
		return this.orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}