package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.ServicioDTO;

public interface ServicesServicio {
	
	List<ServicioDTO> AllServicio();
	ServicioDTO getServio(ServicioDTO servicio);
	ServicioDTO getByIdServicio(ServicioDTO servicio, int id);
	ServicioDTO deleteSericio(int id);

}
