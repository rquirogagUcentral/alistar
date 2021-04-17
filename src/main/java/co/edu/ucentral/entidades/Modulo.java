package co.edu.ucentral.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_modulo")
	private Integer idModulo;

	@Column(name="descripcion_modulo")
	private String descripcionModulo;

	@Column(name="nombre_modulo")
	private String nombreModulo;
	
	
	public Modulo() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdModulo() {
		return idModulo;
	}


	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}


	public String getDescripcionModulo() {
		return descripcionModulo;
	}


	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
	}


	public String getNombreModulo() {
		return nombreModulo;
	}


	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	
	
}
