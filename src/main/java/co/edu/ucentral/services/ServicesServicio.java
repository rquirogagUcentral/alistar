package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.ServicioDTO;

public interface ServicesServicio {
	
	List<ServicioDTO> AllServicio();
	ServicioDTO getServio(ServicioDTO servicio);
	ServicioDTO getByIdServicio(Integer id);
	ServicioDTO deleteSericio(Integer id);
	List<ServicioDTO> getByIdUsuario(Integer id);
	boolean existServiceById(Integer id);
}
