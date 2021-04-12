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
import co.edu.ucentral.dto.UsuarioDto;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IUsuariosRepository;

@RestController
@RequestMapping("/api")
public class UsuarioCtr {

	
	@Autowired
	private IUsuariosRepository usuarioRepository;
	
	
	@GetMapping("/usuario")
	private ResponseEntity<?> getUsuario(){
		
		List<Usuario> listaUsuario=usuarioRepository.findAll();
		return new ResponseEntity<>(listaUsuario,HttpStatus.OK);
	}
	@PostMapping("/getUsuario-password")
	private ResponseEntity<?> getUsuarioAndPassword(@Valid @RequestBody UsuarioDto usuario ,BindingResult bd){
		ResponseDto response=new ResponseDto();
		if(bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuarios = usuarioRepository.findByNumeroIdentificacionAndPassword(usuario.getNumeroIdentificacion(), usuario.getPassword());
		
		return new ResponseEntity<>(usuarios,HttpStatus.OK);
	}
	
	@PostMapping("/save-usuario")
	private ResponseEntity<ResponseDto> saveUsuario(@Valid @RequestBody UsuarioDto usuario ,BindingResult bd){
		ResponseDto response=new ResponseDto();
		if(bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		//Usuario usuarios = usuario;
		//usuarioRepository.save(usuarios);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/health")
	public String healthCheck() {
		return "HEALTHY ACTIVIDAD OK";
	}
	
}
