package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EventoDTO;

public interface ServiceEvento {
	
	List<EventoDTO> eventos(int evento);

}
