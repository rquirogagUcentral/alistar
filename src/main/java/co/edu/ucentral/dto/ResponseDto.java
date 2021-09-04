package co.edu.ucentral.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;


public class ResponseDto {

	private List<Map<String, String>> mensaje;

	public List<Map<String, String>> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<Map<String, String>> mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	@JsonCreator
	@JsonAnyGetter
	public String toString() {
		return "{" + mensaje + "}";
	}

	

	
	
}
