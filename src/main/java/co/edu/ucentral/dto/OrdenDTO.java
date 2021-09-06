package co.edu.ucentral.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OrdenDTO {
	
	
	private Integer idOrden;
	@NotBlank(message = "el nombre del evento no puede estar vacio")
	private String nombreEvento;
	@Min(message = "El usuario no puede ir vacio o en 0", value = 1)
	private Integer usuario;
	private HorarioDTO horario;
	private EstadoDTO estado;
	@Min(message = "El precio no puede estar en 0", value = 1)
	private double precioTotal;
	
	private List<EventoDTO> evento;
	
	public OrdenDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
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

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<EventoDTO> getEvento() {
		return evento;
	}

	public void setEvento(List<EventoDTO> evento) {
		this.evento = evento;
	}

	

}
