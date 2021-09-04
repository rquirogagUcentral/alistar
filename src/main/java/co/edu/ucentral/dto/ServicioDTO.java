package co.edu.ucentral.dto;

import javax.validation.constraints.NotNull;

public class ServicioDTO {

	private Integer idServicio;
	@NotNull(message = "error")
	private String nombreServicio;
	@NotNull(message = "la cateoria no puede ir null")
	private CategoriaDTO categoria;
	@NotNull(message = "las direcciones no pueden ir null")
	private String direccion;
	@NotNull(message = "el proveedor debe existir")
	private UsuarioDTO proveedor;
	private byte[] imagenServicio;
	private String descripcionServicio;
	private double precionUnidad;
	public ServicioDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public ServicioDTO(Integer idServicio,String nombreServicio,
			CategoriaDTO categoria,
			String direccion,
			UsuarioDTO proveedor) {
		super();
		this.idServicio=idServicio;
		this.nombreServicio = nombreServicio;
		this.categoria = categoria;
		this.direccion = direccion;
		this.proveedor = proveedor;
	}



	public ServicioDTO(Integer idServicio,String nombreServicio,
			 CategoriaDTO categoria,
			 String direccion,
			 UsuarioDTO proveedor, byte[] imagenServicio,
			String descripcionServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.categoria = categoria;
		this.direccion = direccion;
		this.proveedor = proveedor;
		this.imagenServicio = imagenServicio;
		this.descripcionServicio = descripcionServicio;
	}



	public ServicioDTO(Integer idServicio,  String nombreServicio,
			CategoriaDTO categoria,
			String direccion,
			UsuarioDTO proveedor, byte[] imagenServicio,
			String descripcionServicio, double precionUnidad) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.categoria = categoria;
		this.direccion = direccion;
		this.proveedor = proveedor;
		this.imagenServicio = imagenServicio;
		this.descripcionServicio = descripcionServicio;
		this.precionUnidad = precionUnidad;
	}



	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public UsuarioDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(UsuarioDTO proveedor) {
		this.proveedor = proveedor;
	}
	public Integer getIdServicio() {
		return idServicio;
	}



	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	
	
	public byte[] getImagenServicio() {
		return imagenServicio;
	}



	public void setImagenServicio(byte[] imagenServicio) {
		this.imagenServicio = imagenServicio;
	}



	public String getDescripcionServicio() {
		return descripcionServicio;
	}



	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}



	public double getPrecionUnidad() {
		return precionUnidad;
	}



	public void setPrecionUnidad(double precionUnidad) {
		this.precionUnidad = precionUnidad;
	}



	@Override
	public String toString() {
		return "ServicioDTO [nombreServicio=" + nombreServicio + ", categoria=" + categoria + ", direccion=" + direccion
				+ ", proveedor=" + proveedor + "]";
	}



	
	
	
}
