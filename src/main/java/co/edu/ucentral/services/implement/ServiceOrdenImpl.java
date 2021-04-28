package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.repository.InterOrdenRepository;
import co.edu.ucentral.services.ServicesOrden;

@Service
public class ServiceOrdenImpl implements ServicesOrden {

	private static Logger logger = LoggerFactory.getLogger(ServiceOrdenImpl.class);
	@Autowired
	private InterOrdenRepository ordenRepository;
	@Autowired
	private IEventoRepository eventoRepositry;
	@Autowired
	private IUsuariosRepository usuarioRepository;

	@Override
	public List<OrdenDTO> listadoOrden() {

		List<Orden> listaOrden = ordenRepository.findAll();

		return listaOrden.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public OrdenDTO getOrden(Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Orden orden = ordenRepository.findByIdOrden(id);
		OrdenDTO orderDto = modelMapper.map(orden, OrdenDTO.class);
		return orderDto;
	}

	@Override
	public boolean deleteOrden(Integer id) {
		ordenRepository.deleteById(id);
		boolean eliminado = ordenRepository.existsById(id);
		return !eliminado;
	}

	@Override
	public OrdenDTO updateOrden(OrdenDTO ordendto) {
		ModelMapper modelMapper = new ModelMapper();
		Orden orden = modelMapper.map(ordendto, Orden.class);
		logger.info("@@@=>Orden  ==> {}", orden.toString());
		Orden response = ordenRepository.save(orden);
		crearEventos(ordendto.getEvento(),response);
		logger.info("@@@=>Orden  ==> {}", response.toString());
		return ordendto;
	}

	private void crearEventos(List<EventoDTO> eventos,Orden response) {
		eventos.stream().forEach(temp->{
			Evento evento = new Evento();
			evento.setOrden(response);
			Usuario usario= usuarioRepository.findByNumeroIdentificacion(temp.getUsuario());
			evento.setUsuario(usario);
			evento.setNombreEvento(temp.getNombreEvento());
			eventoRepositry.save(evento);
		});
		
	}

	private OrdenDTO convertToDto(Orden orden) {
		ModelMapper modelMapper = new ModelMapper();
		OrdenDTO ordendto = modelMapper.map(orden, OrdenDTO.class);
		List<Evento> evento= eventoRepositry.findByOrden(orden);
		;
		ordendto.setEvento(convertEvento(evento));
		return ordendto;
	}

	private List<EventoDTO> convertEvento(List<Evento> evento) {
		ModelMapper modelMapper = new ModelMapper();
		List<EventoDTO> lista= new ArrayList<EventoDTO>();
		evento.stream().forEach(maper->{
			OrdenDTO ordendto = modelMapper.map(maper.getOrden(), OrdenDTO.class);
			lista.add(new EventoDTO(maper.getIdEvento(), maper.getUsuario().getNumeroIdentificacion(),ordendto , maper.getNombreEvento()));
		});
		return lista;
	}

}
