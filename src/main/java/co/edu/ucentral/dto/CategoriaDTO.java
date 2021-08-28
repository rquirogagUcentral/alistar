package co.edu.ucentral.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDTO {

	@Min(value = 1, message = "El valor no puede ser nulo o 0 ")
	private Integer idCategoria;
	@NotBlank(message = "el nombre de la categoria no puede estar vacia ")
	@NotNull(message = "El nombre de la categoria no puede  ")
	private String nombreCategoria;
	
	
	
	public CategoriaDTO() {
		
	}
	
	
	public CategoriaDTO(Integer idCategoria,String nombreCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	@Override
	public String toString() {
		return "CategoriaDTO [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
}
