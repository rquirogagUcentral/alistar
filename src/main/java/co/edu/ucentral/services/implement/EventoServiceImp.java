package co.edu.ucentral.services.implement;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.services.EventoServices;

@Service
public class EventoServiceImp implements EventoServices {

	private static Logger logger = LoggerFactory.getLogger(EventoServiceImp.class);
	@Autowired
	private IEventoRepository eventoRepository;
	@Autowired
	private IUsuariosRepository usuarioRepository;
	
	@Override
	public List<EventoDTO> eventos(int evento) {
		Usuario usuario = usuarioRepository.findByNumeroIdentificacion(evento);
		//List<Evento> listEvento= eventoRepository.findByUsuario(usuario);
		ModelMapper modelMapper = new ModelMapper();
		/*for (Evento evento2 : listEvento) {
			logger.info("@@@@ =>  evento", evento2);
		}*/
		// TODO Auto-generated method stub
		return null;
	}

}
