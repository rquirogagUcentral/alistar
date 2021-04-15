package co.edu.ucentral.dto;

import javax.validation.constraints.NotNull;

public class TipoDocumentoDto {

	@NotNull
	private Integer tipoDocumento;
	@NotNull
	private String descripcionCorta;
	@NotNull
	private String descripcionLarga;

	public TipoDocumentoDto() {
		
	}
	
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

}
