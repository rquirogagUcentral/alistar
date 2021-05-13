package co.edu.ucentral.dto;

import java.util.List;

public class OrdenDTO {
	
	
	private Integer idOrden;
	private Integer servicio;
	private HorarioDTO horario;
	private EstadoDTO estado;
	private double valorTotal;
	private List<EventoDTO> evento;
	private int cantidad;
	public OrdenDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public OrdenDTO(Integer idOrden, Integer servicio, HorarioDTO horario, EstadoDTO estado, double valorTotal,
			List<EventoDTO> evento, int cantidad) {
		super();
		this.idOrden = idOrden;
		this.servicio = servicio;
		this.horario = horario;
		this.estado = estado;
		this.valorTotal = valorTotal;
		this.evento = evento;
		this.cantidad = cantidad;
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

	public HorarioDTO getHorario() {
		return horario;
	}

	public void setHorario(HorarioDTO horario) {
		this.horario = horario;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<EventoDTO> getEvento() {
		return evento;
	}

	public void setEvento(List<EventoDTO> evento) {
		this.evento = evento;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

}
