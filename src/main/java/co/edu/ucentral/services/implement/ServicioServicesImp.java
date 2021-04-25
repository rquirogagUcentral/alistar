package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.CategoriaDTO;
import co.edu.ucentral.dto.DireccionDTO;
import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.services.ServicesServicio;

@Service
public class ServicioServicesImp implements ServicesServicio {

	private static Logger logger = LoggerFactory.getLogger(ServicioServicesImp.class);
	@Autowired
	private IServiciosRepository serviceRepository;

	@Override
	public List<ServicioDTO> AllServicio() {
		List<ServicioDTO> servicio= new ArrayList<ServicioDTO>();
		serviceRepository.findAll().stream().forEach(map->{
			List<CategoriaDTO> categoria = new ArrayList<CategoriaDTO>();
			map.getCategoria().stream().forEach(cat->{
				categoria.add(new CategoriaDTO(cat.getIdCategoria(),cat.getNombreCategoria()));
			});
			List<DireccionDTO> direccion =new ArrayList<>();
			map.getDireccion().stream().forEach(dir->{
				direccion.add(new DireccionDTO(dir.getIdDireccion(),dir.getDireccion()));
			});
			UsuarioDTO proveedor= new UsuarioDTO();
			//BeanUtils.copyProperties(map.getProveedor(), proveedor);
			servicio.add(new ServicioDTO(map.getNombreServicio(),categoria,direccion,proveedor));
		});
		
		
		return servicio;
	}

	@Override
	public ServicioDTO getServio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicioDTO getByIdServicio(ServicioDTO servicio, int id) {
		logger.info("Servicio ,{}, @id {}",servicio,id);
		if(servicio==null) {
			
		}else {
			
			Servicio services = serviceRepository.findByIdServicio(id);
			BeanUtils.copyProperties(services, servicio);
			
		}
		return servicio;
	}

	@Override
	public ServicioDTO deleteSericio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
