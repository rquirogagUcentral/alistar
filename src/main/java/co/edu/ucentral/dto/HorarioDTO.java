package co.edu.ucentral.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class HorarioDTO {

	private Integer idHorario;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicio")
	private Time horaInicio;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_fin")
	private Time horaFin;

	public HorarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public HorarioDTO(Integer idHorario, Date fecha, Time horaInicio, Time horaFin) {
		super();
		this.idHorario = idHorario;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
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

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

}
