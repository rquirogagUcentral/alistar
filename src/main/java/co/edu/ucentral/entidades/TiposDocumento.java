package co.edu.ucentral.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tipos_documentos database table.
 * 
 */
@Entity
@Table(name = "tipos_documentos")
@NamedQuery(name = "TiposDocumento.findAll", query = "SELECT t FROM TiposDocumento t")
public class TiposDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tipo_documento")
	private Integer tipoDocumento;

	@Column(name = "descripcion_corta")
	private String descripcionCorta;

	@Column(name = "descripcion_larga")
	private String descripcionLarga;

	public TiposDocumento() {
	}

	public Integer getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

}