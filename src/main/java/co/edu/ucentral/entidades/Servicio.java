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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicio implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_servicio")
	private Integer idServicio;
	@Column(name = "nombre_servicio", length = 60)
	private String nombreServicio;
	@Column(name = "categoria")
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "idCategoria")
	private List<Categoria> categoria;
	@Column(name = "direccion")
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "idDireccion")
	private List<Direccion> direccion;
	private Integer proveedor;

	public Servicio() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

	
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", categoria=" + categoria
				+ ", direccion=" + direccion + ", proveedor=" + proveedor + "]";
	}

	
	
	
}
