package co.edu.ucentral.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class HorarioDTO {

	private Integer idHorario;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Temporal(TemporalType.TIME)
	private Time hora;
	
	
	public HorarioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public HorarioDTO(Integer idHorario, Date fecha, Time hora) {
		super();
		this.idHorario = idHorario;
		this.fecha = fecha;
		this.hora = hora;
	}
	public Integer getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	
}
