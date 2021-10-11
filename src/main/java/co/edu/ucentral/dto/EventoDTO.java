package co.edu.ucentral.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import co.edu.ucentral.entidades.Estado;
import co.edu.ucentral.entidades.Horario;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Usuario;

public class EventoDTO {

	private Integer idEvento;
	private String nombreEvento;
	private List<OrdenDTO> orden;
	@NotNull
	@Min(value = 1, message = "el valor no puede ser 0")
	private double valorTotal;
	private HorarioDTO horario;
	private Integer usuario;
	private EstadoDTO estado;

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public List<OrdenDTO> getOrden() {
		return orden;
	}

	public void setOrden(List<OrdenDTO> orden) {
		this.orden = orden;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public HorarioDTO getHorario() {
		return horario;
	}

	public void setHorario(HorarioDTO horario) {
		this.horario = horario;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

}
