package co.edu.ucentral.dto;

import java.util.List;


import javax.validation.constraints.NotNull;
import co.edu.ucentral.entidades.Categoria;

public class ServicioDTO {

	private Integer idServicio;
	@NotNull(message = "error")
	private String nombreServicio;
	@NotNull(message = "la cateoria no puede ir null")
	private List<CategoriaDTO> categoria;
	@NotNull(message = "las direcciones no pueden ir null")
	private List<DireccionDTO> direccion;
	@NotNull(message = "el proveedor debe existir")
	private UsuarioDTO proveedor;
	private String imagenServicio;
	private String descripcionServicio;
	public ServicioDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public ServicioDTO(Integer idServicio,String nombreServicio,
			List<CategoriaDTO> categoria,
			List<DireccionDTO> direccion,
			UsuarioDTO proveedor) {
		super();
		this.idServicio=idServicio;
		this.nombreServicio = nombreServicio;
		this.categoria = categoria;
		this.direccion = direccion;
		this.proveedor = proveedor;
	}



	public ServicioDTO(Integer idServicio,String nombreServicio,
			 List<CategoriaDTO> categoria,
			 List<DireccionDTO> direccion,
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

	public List<CategoriaDTO> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaDTO> categoria) {
		this.categoria = categoria;
	}

	public List<DireccionDTO> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<DireccionDTO> direccion) {
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
