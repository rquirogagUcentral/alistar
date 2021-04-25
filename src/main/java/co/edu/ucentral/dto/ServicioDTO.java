package co.edu.ucentral.dto;

import java.util.List;


import javax.validation.constraints.NotNull;
import co.edu.ucentral.entidades.Categoria;

public class ServicioDTO {

	@NotNull(message = "error")
	private String nombreServicio;
	@NotNull(message = "la cateoria no puede ir null")
	private List<CategoriaDTO> categoria;
	@NotNull(message = "las direcciones no pueden ir null")
	private List<DireccionDTO> direccion;
	@NotNull(message = "el proveedor debe existir")
	private UsuarioDTO proveedor;
	
	public ServicioDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public ServicioDTO(String nombreServicio,
			List<CategoriaDTO> categoria,
			List<DireccionDTO> direccion,
			UsuarioDTO proveedor) {
		super();
		this.nombreServicio = nombreServicio;
		this.categoria = categoria;
		this.direccion = direccion;
		this.proveedor = proveedor;
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
	@Override
	public String toString() {
		return "ServicioDTO [nombreServicio=" + nombreServicio + ", categoria=" + categoria + ", direccion=" + direccion
				+ ", proveedor=" + proveedor + "]";
	}
	
	
}
