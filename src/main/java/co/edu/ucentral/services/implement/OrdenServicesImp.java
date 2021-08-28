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

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.HorarioDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.repository.InterOrdenRepository;
import co.edu.ucentral.services.OrdenServices;

@Service
public class OrdenServicesImp implements OrdenServices {

	private static Logger logger = LoggerFactory.getLogger(OrdenServicesImp.class);
	@Autowired
	private InterOrdenRepository ordenRepository;
	@Autowired
	private IEventoRepository eventoRepositry;
	@Autowired
	private IUsuariosRepository usuarioRepository;
	@Autowired
	private IServiciosRepository servicioRepository;

	@Override
	public List<OrdenDTO> listadoOrden() {

		List<Orden> listaOrden = ordenRepository.findAll();

		return listaOrden.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public OrdenDTO getOrden(Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Orden orden = ordenRepository.findByIdOrden(id);
		OrdenDTO orderDto =convertToDto(orden);
		//OrdenDTO orderDto = modelMapper.map(orden, OrdenDTO.class);
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
		Usuario usuario = usuarioRepository.findByNumeroIdentificacion(ordendto.getUsuario());
		orden.setUsuario(usuario);
		List<Evento> envento= sertearLista(ordendto.getEvento());
		orden.setEvento(envento);
		logger.info("@@@=>Orden  ==> {}", orden.toString());
		Orden response = ordenRepository.save(orden);
		crearEventos(ordendto.getEvento(),response);
		logger.info("@@@=>Orden  ==> {}", response.toString());
		return ordendto;
	}

	private List<Evento> sertearLista(List<EventoDTO> evento) {
		List<Evento> enventos =new ArrayList<Evento>();
		
		
		evento.stream().forEach(map->{
			Evento eventoModel = new Evento();
			eventoModel.setCantidad(map.getCantidad());
			eventoModel.setValorTotal(map.getValorTotal());
			Servicio servicio = servicioRepository.findByIdServicio(map.getServicio());
			eventoModel.setServicio(servicio);
			enventos.add(eventoModel);
		});
		
		return enventos;
	}

	private void crearEventos(List<EventoDTO> eventos,Orden response) {
		eventos.stream().forEach(temp->{
			
			Evento eventoModel = new Evento();
			eventoModel.setCantidad(temp.getCantidad());
			eventoModel.setValorTotal(temp.getValorTotal());
			Servicio servicio = servicioRepository.findByIdServicio(temp.getServicio());
			eventoModel.setServicio(servicio);
			eventoModel.setOrden(response);
			eventoRepositry.save(eventoModel);
		});
		
	}

	private OrdenDTO convertToDto(Orden orden) {
		ModelMapper modelMapper = new ModelMapper();
		List<Evento> evento= eventoRepositry.findByOrden(orden);
		orden.setEvento(evento);
		OrdenDTO ordendto = new OrdenDTO();
		ordendto.setUsuario(orden.getUsuario().getNumeroIdentificacion());
		HorarioDTO horarioDto = modelMapper.map(orden.getHorario(), HorarioDTO.class);
		EstadoDTO estadoDto = modelMapper.map(orden.getEstado(), EstadoDTO.class);
		ordendto.setHorario(horarioDto);
		ordendto.setEstado(estadoDto);
		ordendto.setPrecioTotal(orden.getPrecioTotal());
		ordendto.setIdOrden(orden.getIdOrden());
		ordendto.setNombreEvento(orden.getNombreEvento());
		List<EventoDTO> eventoDto =convertEvento(evento);
		ordendto.setEvento(eventoDto);
	// ordendto = modelMapper.map(orden, OrdenDTO.class);
		
		
		//
		return ordendto;
	}

	private List<EventoDTO> convertEvento(List<Evento> evento) {
		List<EventoDTO> lista= new ArrayList<EventoDTO>();
		evento.stream().forEach(maper->{
			
			lista.add(new EventoDTO(maper.getIdEvento(),maper.getValorTotal(),maper.getCantidad(),maper.getServicio().getIdServicio()));
		});
		return lista;
	}

	@Override
	public List<OrdenDTO> getOrdenIdUsuario(int id) {
		Usuario usuario = usuarioRepository.findByNumeroIdentificacion(id);
		List<Orden> listaOrden = ordenRepository.findByUsuario(usuario);

		return listaOrden.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
