package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.entidades.Estado;
import co.edu.ucentral.repository.IEstadoRepository;
import co.edu.ucentral.services.ServiceEstado;

@Service
public class ServiceEstadoImpl implements ServiceEstado {

	private static Logger logger = LoggerFactory.getLogger(ServiceEstadoImpl.class);
	@Autowired
	private IEstadoRepository estadoRepository;

	@Override
	public List<EstadoDTO> listadoService() {

		List<EstadoDTO> estado = new ArrayList<EstadoDTO>();
		
		estadoRepository.findAll().stream().forEach(estados->{
			logger.info("@@ Estado => {}",estados.getIdEstado());
			estado.add(new EstadoDTO(estados.getIdEstado(),estados.getEstado()));
		});
		logger.info("@@ Estado => {}",estado);
		return estado;
	}

	@Override
	public EstadoDTO crearServicio(EstadoDTO servicioDto) {
		Estado estado = new Estado();
		BeanUtils.copyProperties(servicioDto, estado);
		logger.info("@@ Estado => {}",servicioDto.getIdEstado());
		Estado resultado = estadoRepository.save(estado);
		BeanUtils.copyProperties(resultado, servicioDto);
		logger.info("@@ Estado resultado => {}",servicioDto.getIdEstado());
		return servicioDto;
	}

	/*
	 * @Override public boolean crearServicio(ServicioDTO servicio) { Servicio
	 * serviciodb= new Servicio(); Usuario usaurio= new Usuario();
	 * BeanUtils.copyProperties(servicio.getProveedor(), usaurio);
	 * serviciodb.setProveedor(usaurio); BeanUtils.copyProperties(servicio,
	 * serviciodb); servicioRespository.save(serviciodb); return
	 * servicioRespository.existsById(serviciodb.getIdServicio()); }
	 */

}
