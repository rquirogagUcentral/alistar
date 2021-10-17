package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Orden;

public interface OrdenServices {
	
	List<OrdenDTO> listOrden();
	OrdenDTO OrdenByOrden(int eventoid);
	List<Orden> listOrdenByOrden(List<OrdenDTO> orden);
	List<OrdenDTO> listOrdenByEvento(Evento eventoid);
	OrdenDTO createOrden(OrdenDTO ordenDto);
	List<OrdenDTO> createOrdenList(List<OrdenDTO> orden);
	List<OrdenDTO> actualizarOrdenByEnvento(Evento evento);
	void actualizarOrdenDto(EventoDTO eventoDto);
	void eliminarOrden(List<Orden> listadoOrdenes);
}
