package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.services.ServicesServicio;
import co.edu.ucentral.services.UsuarioService;

@Service
public class ServicioServicesImp implements ServicesServicio {

	private static Logger logger = LoggerFactory.getLogger(ServicioServicesImp.class);
	@Autowired
	private IServiciosRepository serviceRepository;
	@Autowired
	private IUsuariosRepository usuarioReposiory;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public List<ServicioDTO> AllServicio() {
		return serviceRepository.findAll().stream().map(this::convertDTO).collect(Collectors.toList());
	}

	@Override
	public ServicioDTO getServio(ServicioDTO serviciodto) {
		logger.info("Servicio DTO en metodo @@=> getServio {}", serviciodto);
		Servicio servicio = converToEntiti(serviciodto);
		servicio = serviceRepository.save(servicio);
		return convertDTO(servicio);
	}

	@Override
	public ServicioDTO getByIdServicio(Integer id) {
		logger.info("Servicio  @id {}", id);
		Servicio servicio = serviceRepository.findByIdServicio(id);
		return convertDTO(servicio);
	}

	@Override
	public ServicioDTO deleteSericio(Integer id) {
		serviceRepository.deleteById(id);
		return null;
	}

	@Override
	public List<ServicioDTO> getByIdUsuario(Integer id) {
		List<ServicioDTO> listadoDto = new ArrayList<ServicioDTO>();

		List<Servicio> listadoServicio = serviceRepository.findByProveedor(id);
		listadoServicio.stream().forEach(map -> {

			/// List<Direccion> direccions =direccionRepository.findByServicio(map);
			map.setDireccion(map.getDireccion());
			UsuarioDTO proveedor = new UsuarioDTO();
			Usuario usuario = usuarioReposiory.findByNumeroIdentificacion(map.getProveedor());
			usuario.setImagen(null);
			BeanUtils.copyProperties(usuario, proveedor);
			
			ModelMapper modelMapper = new ModelMapper();
			ServicioDTO dto = modelMapper.map(map, ServicioDTO.class);
			dto.setProveedor(proveedor);
			listadoDto.add(dto);
		});

		return listadoDto;
	}

	private ServicioDTO convertDTO(Servicio servicio) {
		ModelMapper modelMapper = new ModelMapper();
		ServicioDTO servicioDTO = modelMapper.map(servicio, ServicioDTO.class);
		servicioDTO.setProveedor(usuarioService.usuario(servicio.getProveedor()));
		return servicioDTO;
	}

	private Servicio converToEntiti(ServicioDTO servicioDto) {
		ModelMapper modelMapper = new ModelMapper();
		Integer proveedor = servicioDto.getProveedor().getNumeroIdentificacion();
		
		servicioDto.setProveedor(null);
		Servicio servicioEntiti = modelMapper.map(servicioDto, Servicio.class);
		servicioEntiti.setProveedor(proveedor);
		return servicioEntiti;
	}

	@Override
	public boolean existServiceById(Integer id) {
		boolean exstyservicio = serviceRepository.existsById(id);
		if(exstyservicio)
			return false;
		else
			return true;
	}

	public Servicio getByIdServicioEntidad(Integer id) {
		logger.info("Servicio  @id {}", id);
		return serviceRepository.findByIdServicio(id);
	}
}
