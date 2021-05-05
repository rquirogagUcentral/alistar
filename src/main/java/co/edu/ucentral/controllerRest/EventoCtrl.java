package co.edu.ucentral.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IEventoRepository;
import co.edu.ucentral.repository.IUsuariosRepository;

@RestController
@RequestMapping(path = "/Evento")
public class EventoCtrl {


	@Autowired
	private IEventoRepository eventoRepository;
	@Autowired
	private IUsuariosRepository usuarioRepository;
	
	@GetMapping(path = "Get-evento-Usuario",params ="usuarioId" )
	public ResponseEntity<?> getEventoUsuario(@RequestParam(required = true,value = "usuarioId") Integer usuarioId ){
		Usuario usuario = usuarioRepository.findByNumeroIdentificacion(usuarioId);
		List<Evento> listEvento= eventoRepository.findByUsuario(usuario);
		ResponseDto responseDto = new ResponseDto();
		if(listEvento.isEmpty()) {
			responseDto.setMensaje("No se encuetra ningun servicio");
			return new ResponseEntity<>(responseDto,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listEvento,HttpStatus.OK);
	}
	
	
	
	
	
	
}
