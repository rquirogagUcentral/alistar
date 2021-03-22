package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orden database table.
 * 
 */
@Entity
@NamedQuery(name="Orden.findAll", query="SELECT o FROM Orden o")
public class Orden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idorden;

	private String autorizacion;

	private String estado;

	private Integer idfactura;

	private Integer idservicio;

	private Integer valororden;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="orden")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Horario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idhorario")
	private Horario horario;

	public Orden() {
	}

	public Integer getIdorden() {
		return this.idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public String getAutorizacion() {
		return this.autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}

	public Integer getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}

	public Integer getValororden() {
		return this.valororden;
	}

	public void setValororden(Integer valororden) {
		this.valororden = valororden;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setOrden(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setOrden(null);

		return factura;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}