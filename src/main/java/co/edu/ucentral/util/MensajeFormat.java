package co.edu.ucentral.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;


import co.edu.ucentral.exception.MessageError;

public class MensajeFormat {

	@JsonFormat
	public String formatoMensaje(BindingResult resutl) {
		List<Map<String, String>> error = resutl.getFieldErrors().stream().map(err -> {
			Map<String, String> er = new HashMap<>();
			er.put(err.getField(), err.getDefaultMessage());
			return er;
		}).collect(Collectors.toList());
		MessageError errorMensaje = new MessageError(0, error);
		ObjectMapper maper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = maper.writeValueAsString(errorMensaje);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonString;
	}
}
