package co.edu.ucentral.dto;

import javax.validation.constraints.NotNull;

public class EstadoDTO {

	private Integer idEstado;
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
