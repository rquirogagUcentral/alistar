package co.edu.ucentral.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EventoDTO {

	private Integer idEvento;
	private OrdenDTO orden;
	@NotNull
	@Min(value = 1, message = "el valor no puede ser 0")
	private double valorTotal;
	@Min(value = 1, message = "el valor no puede ser 0")
	private int cantidad;
	@Min(value = 1, message = "Servicio no valido")
	private Integer servicio;
	
	public EventoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EventoDTO(Integer idEvento, double valorTotal, int cantidad, Integer servicio) {
		super();
		this.idEvento = idEvento;
		
		this.valorTotal = valorTotal;
		this.cantidad = cantidad;
		this.servicio = servicio;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public OrdenDTO getOrden() {
		return orden;
	}

	public void setOrden(OrdenDTO orden) {
		this.orden = orden;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	
}
