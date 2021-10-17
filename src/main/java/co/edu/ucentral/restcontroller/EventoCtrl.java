package co.edu.ucentral.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.EventoDTO;
import co.edu.ucentral.services.EventoServices;

@RestController
@RequestMapping(path = "/Evento")
public class EventoCtrl {

	
	@Autowired
	private EventoServices evento;
	
	
	@GetMapping()
	public ResponseEntity<?> getAllEventos() {
		List<EventoDTO>  eventoDto = evento.getAllEvents();
		return new ResponseEntity<>(eventoDto, HttpStatus.OK);
	}

	@GetMapping(path = "Get-evento-Usuario", params = "usuarioId")
	public ResponseEntity<?> getEventoUsuario(@RequestParam(required = true, value = "usuarioId") Integer usuarioId) {
		List<EventoDTO>  eventoDto = evento.getAllEventsByIdUser(usuarioId);
		return new ResponseEntity<>(eventoDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "getEventoById", params = "id")
	public ResponseEntity<?> getByIdEvento(@RequestParam(required = true, value = "id") Integer id) {
		EventoDTO eventoDto =  evento.getByEvento(id);
		return new ResponseEntity<>(eventoDto,HttpStatus.OK);
	}
	@PostMapping(value = "/save-evento")
	public ResponseEntity<?> postEvento(@Valid @RequestBody EventoDTO eventoDto) {
		eventoDto = evento.guardarEvento(eventoDto);
		return new ResponseEntity<>(eventoDto, HttpStatus.OK);
	}
	@PutMapping(value = "/update-evento")
	public ResponseEntity<?> putEvento(@Valid @RequestBody EventoDTO eventoDto) {
		eventoDto = evento.updateEvent(eventoDto);
		return new ResponseEntity<>(eventoDto, HttpStatus.OK);
	}
	@DeleteMapping(path = "deleteEvento", params = "id")
	public ResponseEntity<?> deleteEvento(@RequestParam(required = true, value = "id") Integer id) {
		evento.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
