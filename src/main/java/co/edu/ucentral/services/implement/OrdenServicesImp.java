package co.edu.ucentral.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.repository.InterOrdenRepository;
import co.edu.ucentral.services.EventoServices;
import co.edu.ucentral.services.OrdenServices;
import co.edu.ucentral.services.ServicesServicio;

@Service
public class OrdenServicesImp implements OrdenServices {

	private static Logger logger = LoggerFactory.getLogger(OrdenServicesImp.class);
	@Autowired
	private InterOrdenRepository ordenRepository;
	@Autowired
	private ServicesServicio servicio;
	@Autowired
	private EventoServices eventoServis;
	
	@Override
	public List<OrdenDTO> listOrden() {
		List<Orden> listaOrden = ordenRepository.findAll();
		return listaOrden.stream().map(this::convertToDto ).collect(Collectors.toList());	
	}

	@Override
	public List<OrdenDTO> listOrdenByEvento(Evento eventoid) {
		List<Orden> listaOrden = ordenRepository.findByEvento(eventoid);
		return listaOrden.stream().map(this::convertToDto ).collect(Collectors.toList());
	}

	@Override
	public OrdenDTO createOrden(OrdenDTO ordenDto) {
		Orden orden = converToEntity(ordenDto);
		orden = ordenRepository.save(orden);
		return convertToDto(orden);
	}

	

	@Override
	public List<OrdenDTO> createOrdenList(List<OrdenDTO> orden) {
		
		return orden.stream().map(this::crearOrden).collect(Collectors.toList());
		 
	}

	private OrdenDTO crearOrden(OrdenDTO ordenDto) {
		Orden orden = converToEntity(ordenDto);
		orden = ordenRepository.save(orden);
		return convertToDto(orden);
	}
	
	private OrdenDTO convertToDto(Orden orden) {
		OrdenDTO ordendto = new OrdenDTO();
		ordendto.setIdOrden(orden.getIdOrden());
		ordendto.setCantidad(orden.getCantidad());
		ordendto.setServicio(orden.getServicio().getIdServicio());
		ordendto.setTotalOrden(orden.getTotalOrden());	
		return ordendto;
	}
	private Orden converToEntity(OrdenDTO ordenDto) {
		ModelMapper modelMapper = new ModelMapper();
		Servicio servicio = this.servicio.getByIdServicioEntidad(ordenDto.getServicio());
		ordenDto.setServicio(null);
		Orden orden = modelMapper.map(ordenDto, Orden.class);
		orden.setServicio(servicio);
		return orden;
	}

	@Override
	public OrdenDTO OrdenByOrden(int eventoid) {
		Orden orden = ordenRepository.findByIdOrden(eventoid);
		return convertToDto(orden);
	}
	public Orden OrdenByIDOrden(OrdenDTO orden) {
		
		return  ordenRepository.findByIdOrden(orden.getIdOrden());
	}
	@Override
	public List<Orden> listOrdenByOrden(List<OrdenDTO> orden) {
		List<Orden> ordenes= orden.stream().map(this::OrdenByIDOrden).collect(Collectors.toList());
		return ordenes;
	}

	@Override
	public List<OrdenDTO> actualizarOrdenByEnvento(Evento evento) {
		evento.getOrden().stream().forEach(o->{
			o.setEvento(evento);
			ordenRepository.save(o);
		});
		return null;
	}

	@Override
	public void actualizarOrdenDto(EventoDTO eventoDto) {
		Evento evento= eventoServis.getByEventoEntiy(eventoDto.getIdEvento());
		evento.setOrden(listOrdenByOrden(eventoDto.getOrden()));
		actualizarOrdenByEnvento(evento);
	}

	
		
	

}
