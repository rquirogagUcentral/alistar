package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EstadoDTO;

public interface EstadoService {

	List<EstadoDTO> listadoService();
	EstadoDTO createEstate(EstadoDTO estadoDto);
	EstadoDTO update(EstadoDTO estadoDto);
	void delete(int id);
}
