package co.edu.ucentral.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoDTO {

	@Min(value = 1, message = "el valor no puede ir vacio o 0")
	private Integer idEstado;
	@NotBlank(message = "El estado no puede ir vacio")
	@NotNull(message = "El estado no puede ir vacio")
	private String estado;

	public EstadoDTO() {
		
	}

	public EstadoDTO(Integer idEstado, String estado) {
		super();
		this.idEstado = idEstado;
		this.estado = estado;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstadoDTO [idEstado=" + idEstado + ", estado=" + estado + "]";
	}

}
