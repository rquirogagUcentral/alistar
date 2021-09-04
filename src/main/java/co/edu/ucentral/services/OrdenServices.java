package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.OrdenDTO;

public interface OrdenServices {
	
	List<OrdenDTO> listadoOrden();
	OrdenDTO getOrden(Integer id);
	boolean deleteOrden(Integer id);
	OrdenDTO updateOrden(OrdenDTO orden);
	List<OrdenDTO> getOrdenIdUsuario(int id);
	

}
