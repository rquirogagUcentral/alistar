package co.edu.ucentral.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.dto.HorarioDTO;
import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.services.EventoServices;

@SpringBootTest
public class TestEvento {
	
	@Autowired
	private EventoServices evento;
	
	@Test
	public void testEventosSeleccionados() {
		List<EventoDTO> enventosDto= evento.getAllEvents();
		assertNotNull(enventosDto);
	}
	
	@Test
	public void testEventosGuardarEvento() {
		
		EventoDTO eventoDto = new EventoDTO();
		eventoDto.setEstado(new EstadoDTO(1, "Actualizado"));
		eventoDto.setUsuario(827982587);
		OrdenDTO ordenDto = new OrdenDTO(1,1,1,80000);
		List<OrdenDTO> listOrden= new ArrayList<>(); 
		listOrden.add(ordenDto);
		eventoDto.setOrden(listOrden);
		eventoDto.setValorTotal(80000);
		EventoDTO enventosDto= evento.guardarEvento(eventoDto);
		assertNotNull(enventosDto);
	}
}
