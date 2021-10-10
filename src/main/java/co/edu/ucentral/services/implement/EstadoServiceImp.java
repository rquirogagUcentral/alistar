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

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.entidades.Estado;
import co.edu.ucentral.repository.IEstadoRepository;
import co.edu.ucentral.services.EstadoService;

@Service
public class EstadoServiceImp implements EstadoService {

	private static Logger logger = LoggerFactory.getLogger(EstadoServiceImp.class);
	@Autowired
	private IEstadoRepository estadoRepository;

	@Override
	public List<EstadoDTO> listadoService() {

		List<EstadoDTO> estado = estadoRepository.findAll().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
		logger.info("@@ Estado => {}", estado);
		return estado;
	}

	@Override
	public EstadoDTO createEstate(EstadoDTO estadoDto) {
		Estado estado = convertToEntiti(estadoDto);
		Estado temp = estadoRepository.findByEstado(estado.getEstado());
		if(temp!=null) {
			estado = estadoRepository.save(temp);		
		}
		else
			estado = estadoRepository.save(estado);
		return convertToDTO(estado);
	}

	@Override
	public EstadoDTO update(EstadoDTO estadoDto) {
		Estado estado = convertToEntiti(estadoDto);
		Estado temp = estadoRepository.findByEstado(estado.getEstado()); 
		if(temp!=null) {
			estado = estadoRepository.save(temp);		
		}
		else
			estado = estadoRepository.save(estado);
		
		return convertToDTO(estado);
	}

	@Override
	public void delete(int id) {
		estadoRepository.deleteById(id);
	}

	private EstadoDTO convertToDTO(Estado estado) {
		ModelMapper modelMapper = new ModelMapper();
		EstadoDTO estadoDto = modelMapper.map(estado, EstadoDTO.class);
		return estadoDto;
	}

	private Estado convertToEntiti(EstadoDTO estadoDto) {
		ModelMapper modelMapper = new ModelMapper();
		Estado estado = modelMapper.map(estadoDto, Estado.class);
		return estado;
	}

}
