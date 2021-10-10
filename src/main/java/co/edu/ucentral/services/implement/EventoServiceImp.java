package co.edu.ucentral.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.HorarioDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Horario;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.HorarioRepository;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.services.EstadoService;
import co.edu.ucentral.services.EventoServices;
import co.edu.ucentral.services.OrdenServices;
import co.edu.ucentral.services.ServicesServicio;
import co.edu.ucentral.services.UsuarioService;

@Service
public class EventoServiceImp implements EventoServices {

	private static Logger logger = LoggerFactory.getLogger(EventoServiceImp.class);
	@Autowired
	private IEventoRepository eventoRepo;
	@Autowired
	private EstadoService estado;
	@Autowired
	private HorarioRepository ItfhorarioRepo;
	@Autowired
	private OrdenServices orden;
	@Autowired
	private UsuarioService usuario;

	@Override
	public List<EventoDTO> getAllEvents() {
		logger.info("@@@ getAllEvents() >>>  ");
		List<EventoDTO> eventoDto = eventoRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
		logger.info("@@@ getAllEvents() cantidad >>> {} ", eventoDto.size());
		return eventoDto;
	}

	private EventoDTO convertToDTO(Evento evento) {
		Usuario usaurio = evento.getUsuario();
		ModelMapper modelMapper = new ModelMapper();
		evento.setOrden(null);
		evento.setUsuario(null);
		EventoDTO eventoDto = modelMapper.map(evento, EventoDTO.class);
		eventoDto.setOrden(orden.listOrdenByEvento(evento));
		
		if(usaurio != null) {
			eventoDto.setUsuario(usaurio.getNumeroIdentificacion());
			
		}else if(evento.getUsuario()==null) {
			Evento eve = eventoRepo.findByIdEvento(evento.getIdEvento());
			eventoDto.setUsuario(eve.getUsuario().getNumeroIdentificacion());
		}
		
		return eventoDto;
	}

	@Override
	public EventoDTO getByEvento(Integer eventoId) {
		Evento evento = eventoRepo.findByIdEvento(eventoId);
		return convertToDTO(evento);
	}

	@Override
	public List<EventoDTO> getAllEventsByIdUser(Integer idUsuario) {
		Usuario usuario = this.usuario.usuarioById(idUsuario);
		List<EventoDTO> eventoDto= null;
		if(usuario!= null) {
			eventoDto = eventoRepo.findByUsuario(usuario).stream().map(this::convertToDTO).collect(Collectors.toList()); 
		}
		return eventoDto;
	}

	@Override
	public EventoDTO updateEvent(EventoDTO eventoDto) {
		EstadoDTO estadoDto = estado.update(eventoDto.getEstado());
		eventoDto.setEstado(estadoDto);
		Evento evento = convertToEntiti(eventoDto);
		Horario horario = ItfhorarioRepo.findByIdHorario(eventoDto.getHorario().getIdHorario());
		if(horario !=null) {
			ItfhorarioRepo.save(horario);
		}
		evento.setHorario(horario);
		Usuario usuario = this.usuario.usuarioById(eventoDto.getUsuario());
		evento.setUsuario(usuario);
		evento = eventoRepo.save(evento);
		orden.actualizarOrdenDto(eventoDto);
		return convertToDTO(evento);
	}

	@Override
	public void deleteEvent(Integer id) {
		eventoRepo.deleteById(id);
	}

	@Override
	public EventoDTO guardarEvento(EventoDTO eventoDto) {
		EstadoDTO estadoDto = estado.update(eventoDto.getEstado());
		eventoDto.setEstado(estadoDto);
		Evento evento = convertToEntiti(eventoDto);
		Horario horario = ItfhorarioRepo.save(convertToEntitiHorario(eventoDto.getHorario()));
		evento.setHorario(horario);
		List<OrdenDTO> listOrden = orden.createOrdenList(eventoDto.getOrden());
		evento.setOrden(orden.listOrdenByOrden(listOrden));
		Usuario usuario = this.usuario.usuarioById(eventoDto.getUsuario());
		evento.setUsuario(usuario);
		evento = eventoRepo.save(evento);
		orden.actualizarOrdenByEnvento(evento);
		return convertToDTO(evento);
	}

	private Evento convertToEntiti(EventoDTO eventodto) {
		ModelMapper modelMapper = new ModelMapper();
		Evento evento = modelMapper.map(eventodto, Evento.class);
		
		return evento;
	}

	private Horario convertToEntitiHorario(HorarioDTO horariodto) {
		ModelMapper modelMapper = new ModelMapper();
		Horario horario = modelMapper.map(horariodto, Horario.class);
		return horario;
	}

	private HorarioDTO convertToDTOHorario(Horario horario) {
		ModelMapper modelMapper = new ModelMapper();
		HorarioDTO horarioDto = modelMapper.map(horario, HorarioDTO.class);
		return horarioDto;
	}

	@Override
	public Evento getByEventoEntiy(Integer eventoId) {
		return eventoRepo.findByIdEvento(eventoId);
	}

	
}
