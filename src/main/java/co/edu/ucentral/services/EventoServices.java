package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.entidades.Evento;

public interface EventoServices {
	
	List<EventoDTO> getAllEvents();
	EventoDTO getByEvento(Integer eventoId);
	Evento getByEventoEntiy(Integer eventoId);
	EventoDTO guardarEvento(EventoDTO eventoDto);
	List<EventoDTO> getAllEventsByIdUser(Integer idUsuario);
	EventoDTO updateEvent(EventoDTO eventoDto);
	void deleteEvent(Integer id);
	
	
	

}
