package co.edu.ucentral.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class UsuarioSesionDto {

	@NotNull
	@Size(min = 1, max = 30)
	private Integer usuario;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 30)
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
