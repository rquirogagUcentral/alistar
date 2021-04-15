package co.edu.ucentral.controllerRest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.dto.UsuarioSesionDto;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IUsuariosRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioCtr {

	
	@Autowired
	private IUsuariosRepository usuarioRepository;
	
	
	@GetMapping(value = "/usuario")
	private ResponseEntity<?> getUsuario(){
		
		List<Usuario> listaUsuario=usuarioRepository.findAll();
		if(listaUsuario.isEmpty()) {
			return new ResponseEntity<>(listaUsuario,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listaUsuario,HttpStatus.OK);
	}
	@PostMapping(value = "/getUsuario-password")
	private ResponseEntity<?> getUsuarioAndPassword(@Valid @RequestBody UsuarioSesionDto usuario  ,BindingResult bd){
		ResponseDto response=new ResponseDto();
		if(bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuarios = usuarioRepository.findByNumeroIdentificacionAndPassword(usuario.getUsuario(), usuario.getPassword());
		if(usuarios==null) {
			return new ResponseEntity<>(usuarios,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(usuarios,HttpStatus.OK);
	}
	
	@PostMapping(value = "/save-usuario")
	private ResponseEntity<ResponseDto> saveUsuario(@Valid @RequestBody UsuarioDTO usuario ,BindingResult bd){
		
		ResponseDto response=new ResponseDto();
		if(bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		try {
			//Usuario usuarios = usuario;
			//usuarioRepository.save(usuarios);
				
		} catch (Exception e) {
			response.setMensaje("Error guardando el usuario " + e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value = "/health")
	public String healthCheck() {
		return "HEALTHY ACTIVIDAD OK";
	}
	
}
