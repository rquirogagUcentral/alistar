package co.edu.ucentral.dto;

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
	private Date horaInicio;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_fin")
	private Date horaFin;

	public HorarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public HorarioDTO(Integer idHorario, Date fecha, Date horaInicio, Date horaFin) {
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

}
