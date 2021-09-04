package co.edu.ucentral.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UsuarioSesionDto {

	@Min(value = 1,message = "el umero no puede ser 0")
	private Integer usuario;
	@NotEmpty(message = "El password no puede ir vacio")
	private String password;

	public UsuarioSesionDto() {
		
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
