package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.entidades.Servicio;

public interface ServicesServicio {
	
	List<ServicioDTO> AllServicio();
	ServicioDTO getServio(ServicioDTO servicio);
	ServicioDTO getByIdServicio(Integer id);
	Servicio getByIdServicioEntidad(Integer id);
	ServicioDTO deleteSericio(Integer id);
	List<ServicioDTO> getByIdUsuario(Integer id);
	boolean existServiceById(Integer id);
}
