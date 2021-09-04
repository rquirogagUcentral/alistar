package co.edu.ucentral.dto;

public class EventoDTO {

	private Integer idEvento;
	private OrdenDTO orden;
	private double valorTotal;
	private int cantidad;
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
