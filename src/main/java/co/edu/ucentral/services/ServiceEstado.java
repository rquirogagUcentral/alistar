package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EstadoDTO;

public interface ServiceEstado {

	List<EstadoDTO> listadoService();

	EstadoDTO crearServicio(EstadoDTO estadoDto);
}
