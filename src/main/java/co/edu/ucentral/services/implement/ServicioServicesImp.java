package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.CategoriaDTO;
import co.edu.ucentral.dto.DireccionDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Categoria;
import co.edu.ucentral.entidades.Direccion;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.ICaegoriaRepository;
import co.edu.ucentral.repository.IDireccionRepository;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.services.ServicesServicio;

@Service
public class ServicioServicesImp implements ServicesServicio {

	private static Logger logger = LoggerFactory.getLogger(ServicioServicesImp.class);
	@Autowired
	private IServiciosRepository serviceRepository;
	@Autowired
	private IUsuariosRepository usuarioReposiory;
	@Autowired
	private ICaegoriaRepository categoriaRepository;
	@Autowired
	private IDireccionRepository direccionRepository;

	@Override
	public List<ServicioDTO> AllServicio() {
		List<ServicioDTO> servicio = new ArrayList<ServicioDTO>();
		serviceRepository.findAll().stream().forEach(map -> {
			List<CategoriaDTO> categoria = new ArrayList<CategoriaDTO>();
			
			List<Categoria> cate= categoriaRepository.findByServicio(map);
			List<Direccion> direccions =direccionRepository.findByServicio(map);
			map.setCategoria(cate);
			map.setDireccion(direccions);
			map.getCategoria().stream().forEach(cat -> {
				categoria.add(new CategoriaDTO(cat.getIdCategoria(), cat.getNombreCategoria()));
			});
			List<DireccionDTO> direccion = new ArrayList<>();
			map.getDireccion().stream().forEach(dir -> {
				direccion.add(new DireccionDTO(dir.getIdDireccion(), dir.getDireccion()));
			});
			UsuarioDTO proveedor = new UsuarioDTO();
			Usuario usuario = usuarioReposiory.findByNumeroIdentificacion(map.getProveedor());
			BeanUtils.copyProperties(usuario, proveedor);
			servicio.add(
					new ServicioDTO(map.getIdServicio(), map.getNombreServicio(), categoria, direccion, proveedor,map.getImagenServicio(),map.getDescripcionServicio()));
		});

		return servicio;
	}

	@Override
	public ServicioDTO getServio(ServicioDTO servicio) {
		Servicio servis = new Servicio();
		logger.info("@@@ servicio => {}", servicio.toString());
		List<Categoria> categoria = new ArrayList<Categoria>();
		List<Direccion> direccion = new ArrayList<Direccion>();
		
		servis.setDireccion(direccion);
		servis.setCategoria(categoria);
		servis.setProveedor(servicio.getProveedor().getNumeroIdentificacion());
		servis.setNombreServicio(servicio.getNombreServicio());
		servis.setIdServicio(servicio.getIdServicio());
		logger.info("@@@ servicio => {}", servis.toString());
		Servicio retorno = serviceRepository.save(servis);
		servicio.getCategoria().stream().forEach(map -> {
			categoria.add(new Categoria(map.getIdCategoria(), map.getNombreCategoria()));
			categoriaRepository.save(new Categoria(map.getIdCategoria(), map.getNombreCategoria(),retorno));
		});
		servicio.getDireccion().stream().forEach(map -> {
			direccion.add(new Direccion(map.getIdDireccion(), map.getDireccion()));
			direccionRepository.save(new Direccion(map.getIdDireccion(), map.getDireccion(),retorno));
		});
		logger.info("@@@ servicio => {}", servicio.toString());
		BeanUtils.copyProperties(retorno, servicio);
		return servicio;
	}

	@Override
	public ServicioDTO getByIdServicio(ServicioDTO servicio, int id) {
		logger.info("Servicio ,{}, @id {}", servicio, id);
		try {

			if (servicio == null) {
				List<CategoriaDTO> categoria = new ArrayList<CategoriaDTO>();
				List<DireccionDTO> direccion = new ArrayList<DireccionDTO>();
				Servicio services = serviceRepository.findByIdServicio(id);
				List<Categoria> cate= categoriaRepository.findByServicio(services);
				List<Direccion> direccions =direccionRepository.findByServicio(services);
				services.setCategoria(cate);
				services.setDireccion(direccions);
				services.getCategoria().stream().forEach(map -> {
					categoria.add(new CategoriaDTO(map.getIdCategoria(), map.getNombreCategoria()));
				});
				services.getDireccion().stream().forEach(map -> {
					direccion.add(new DireccionDTO(map.getIdDireccion(), map.getDireccion()));
				});
				UsuarioDTO proveedor = new UsuarioDTO();
				Usuario usuario = usuarioReposiory
						.findByNumeroIdentificacion(services.getProveedor());
				BeanUtils.copyProperties(usuario, proveedor);
				servicio = new ServicioDTO();
				servicio.setCategoria(categoria);
				servicio.setDireccion(direccion);
				servicio.setProveedor(proveedor);
				BeanUtils.copyProperties(services, servicio);
			} else {
				Servicio servis = new Servicio();
				BeanUtils.copyProperties(servicio, servis);
				serviceRepository.findById(id).map(mod -> {
					serviceRepository.save(servis);
					return mod;
				});
				Servicio retorno = serviceRepository.findByIdServicio(id);
			}

		} catch (Exception e) {
			logger.error("@@ Error en la consulta no hay datos {}",e.getMessage());
		}
		return servicio;
	}

	@Override
	public ServicioDTO deleteSericio(int id) {
		serviceRepository.deleteById(id);
		return null;
	}

	@Override
	public List<ServicioDTO> getByIdUsuario(int id) {
		List<ServicioDTO> listadoDto= new ArrayList<ServicioDTO>();
		
		List<Servicio> listadoServicio=serviceRepository.findByProveedor(id);
		listadoServicio.stream().forEach(map->{
			List<Categoria> cate= categoriaRepository.findByServicio(map);
			List<Direccion> direccions =direccionRepository.findByServicio(map);
			map.setCategoria(cate);
			map.setDireccion(direccions);
			UsuarioDTO proveedor = new UsuarioDTO();
			Usuario usuario = usuarioReposiory.findByNumeroIdentificacion(map.getProveedor());
			BeanUtils.copyProperties(usuario, proveedor);
			ModelMapper modelMapper = new ModelMapper();
			ServicioDTO dto=modelMapper.map(map, ServicioDTO.class);
			dto.setProveedor(proveedor);
			listadoDto.add(dto);
		});
		
		return listadoDto ;
	}

}
