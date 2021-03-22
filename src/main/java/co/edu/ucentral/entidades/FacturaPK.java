package co.edu.ucentral.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the factura database table.
 * 
 */
@Embeddable
public class FacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer idfactura;

	@Column(insertable=false, updatable=false)
	private Integer idevento;

	public FacturaPK() {
	}
	public Integer getIdfactura() {
		return this.idfactura;
	}
	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}
	public Integer getIdevento() {
		return this.idevento;
	}
	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FacturaPK)) {
			return false;
		}
		FacturaPK castOther = (FacturaPK)other;
		return 
			this.idfactura.equals(castOther.idfactura)
			&& this.idevento.equals(castOther.idevento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idfactura.hashCode();
		hash = hash * prime + this.idevento.hashCode();
		
		return hash;
	}
}