package co.edu.ucentral.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.services.EventoServices;

@Service
public class EventoServiceImp implements EventoServices {

	private static Logger logger = LoggerFactory.getLogger(EventoServiceImp.class);
	@Autowired
	private IEventoRepository eventoRepository;
	
	@Override
	public List<EventoDTO> eventos(int ordenDto) {
		List<EventoDTO> eventodto = eventoRepository.findByOrden(ordenDto).stream().map(this::convertToDTO).collect(Collectors.toList());
		return eventodto;
	}
	
	private EventoDTO convertToDTO(Evento evento) {
		ModelMapper modelMapper = new ModelMapper();
		EventoDTO eventoDto= modelMapper.map(evento, EventoDTO.class);
		return  eventoDto;
	}

	@Override
	public List<EventoDTO> listadoEventos() {
		return eventoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public EventoDTO guardarEvento(EventoDTO eventodto) {
		Evento evento = convertToEntiti(eventodto);
	   	evento = eventoRepository.save(evento);
		return convertToDTO(evento);
	}

	private Evento convertToEntiti(EventoDTO eventodto) {
		ModelMapper modelMapper = new ModelMapper();
		Evento evento= modelMapper.map(eventodto, Evento.class);
		return  evento;
	}

	@Override
	public EventoDTO actualizarEvento(EventoDTO evento) {
		// TODO Auto-generated method stub
		return null;
	}

}
