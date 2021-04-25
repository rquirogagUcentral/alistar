package co.edu.ucentral.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CategoriaDTO {

	@NotNull(message = "la categoria no puede ir vacia")
	@Min(value = 1,message = "La categoria debe tener mas de un digito")
	private Integer idCategoria;
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
