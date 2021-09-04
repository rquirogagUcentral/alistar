package co.edu.ucentral.dto;

public class DireccionDTO {

	private Integer idDireccion;
	private String direccion;
	public DireccionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public DireccionDTO(Integer idDireccion, String direccion) {
		super();
		this.idDireccion = idDireccion;
		this.direccion = direccion;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "DireccionDTO [idDireccion=" + idDireccion + ", direccion=" + direccion + "]";
	}
	
	
}
