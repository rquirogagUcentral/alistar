package co.edu.ucentral.dto;

public class EventoDTO {

	private Integer idEvento;
	private Integer usuario;
	private OrdenDTO idOrden;

	private String nombreEvento;
	
	public EventoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EventoDTO(Integer idEvento, Integer usuario, OrdenDTO idOrden, String nombreEvento) {
		super();
		this.idEvento = idEvento;
		this.usuario = usuario;
		this.idOrden = idOrden;
		this.nombreEvento = nombreEvento;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public OrdenDTO getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(OrdenDTO idOrden) {
		this.idOrden = idOrden;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
	
}
