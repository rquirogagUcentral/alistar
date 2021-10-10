package co.edu.ucentral.dto;

import javax.validation.constraints.Min;

public class OrdenDTO {

	private Integer idOrden;
	@Min(message = "El usuario no puede ir vacio o en 0", value = 1)
	private Integer servicio;
	@Min(message = "El usuario no puede ir vacio o en 0", value = 1)
	private int cantidad;
	@Min(message = "El usuario no puede ir vacio o en 0", value = 1)
	private double totalOrden;

	public OrdenDTO() {
	}
	public OrdenDTO(Integer idOrden, Integer servicio, int cantidad, double totalOrden) {
		super();
		this.idOrden = idOrden;
		this.servicio = servicio;
		this.cantidad = cantidad;
		this.totalOrden = totalOrden;
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotalOrden() {
		return totalOrden;
	}

	public void setTotalOrden(double totalOrden) {
		this.totalOrden = totalOrden;
	}

}
