package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipos_documentos database table.
 * 
 */
@Entity
@Table(name = "tipos_documentos")
@NamedQuery(name = "TiposDocumento.findAll", query = "SELECT t FROM TiposDocumento t")
public class TiposDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

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