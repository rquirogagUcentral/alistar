package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EventoDTO;

public interface EventoServices {
	
	List<EventoDTO> eventos(int ordenDto);
	List<EventoDTO> listadoEventos();
	EventoDTO guardarEvento(EventoDTO evento);
	EventoDTO actualizarEvento(EventoDTO evento);
	
	

}
