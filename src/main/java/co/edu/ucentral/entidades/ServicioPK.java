package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the servicio database table.
 * 
 */
@Embeddable
public class ServicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer idservicio;

	@Column(insertable=false, updatable=false)
	private Integer identidad;

	public ServicioPK() {
	}
	public Integer getIdservicio() {
		return this.idservicio;
	}
	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
	}
	public Integer getIdentidad() {
		return this.identidad;
	}
	public void setIdentidad(Integer identidad) {
		this.identidad = identidad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServicioPK)) {
			return false;
		}
		ServicioPK castOther = (ServicioPK)other;
		return 
			this.idservicio.equals(castOther.idservicio)
			&& this.identidad.equals(castOther.identidad);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idservicio.hashCode();
		hash = hash * prime + this.identidad.hashCode();
		
		return hash;
	}
}