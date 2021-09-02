package co.edu.ucentral.entidades;

import java.io.Serializable;

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
@Table(name = "servicios")
public class Servicio implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_servicio")
	private Integer idServicio;
	@Column(name = "nombre_servicio", length = 60)
	private String nombreServicio;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria", referencedColumnName = "id_categoria" )
	private Categoria categoria;
	@Column(name = "direccion")
	private String direccion;
	private Integer proveedor;
	@Column(name = "descripcion_servicio")
	private String descripcionServicio;
	@Column(name = "imagen")
	private byte[] imagenServicio;
	@Column(name = "precio_servicio")
	private Double precionUnidad;
	
	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public byte[] getImagenServicio() {
		return imagenServicio;
	}

	public void setImagenServicio(byte[] imagenServicio) {
		this.imagenServicio = imagenServicio;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", categoria=" + categoria
				+ ", direccion=" + direccion + ", proveedor=" + proveedor + "]";
	}

	public Double getPrecionUnidad() {
		return precionUnidad;
	}

	public void setPrecionUnidad(Double precionUnidad) {
		this.precionUnidad = precionUnidad;
	}

	
	
	
}
