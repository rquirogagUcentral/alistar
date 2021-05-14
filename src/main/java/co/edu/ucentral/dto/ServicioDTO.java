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
	private String imagenServicio;
	private String descripcionServicio;
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
			 UsuarioDTO proveedor, String imagenServicio,
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
	
	
	public String getImagenServicio() {
		return imagenServicio;
	}



	public void setImagenServicio(String imagenServicio) {
		this.imagenServicio = imagenServicio;
	}



	public String getDescripcionServicio() {
		return descripcionServicio;
	}



	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}



	@Override
	public String toString() {
		return "ServicioDTO [nombreServicio=" + nombreServicio + ", categoria=" + categoria + ", direccion=" + direccion
				+ ", proveedor=" + proveedor + "]";
	}



	
	
	
}
