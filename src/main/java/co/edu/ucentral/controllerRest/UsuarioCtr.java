package co.edu.ucentral.controllerRest;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.dto.UsuarioSesionDto;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IUsuariosRepository;

@RestController
@RequestMapping( path = "/Usuarios")
public class UsuarioCtr {

	private static Logger logger = LoggerFactory.getLogger(UsuarioCtr.class);
	@Autowired
	private IUsuariosRepository usuarioRepository;

	@GetMapping()
	private ResponseEntity<?> getUsuario() throws SQLException {

		List<Usuario> listaUsuario = usuarioRepository.findAll();
		if (listaUsuario.isEmpty()) {
			return new ResponseEntity<>(listaUsuario, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
	}

	@PostMapping(value = "/getUsuario-password")
	private ResponseEntity<?> getUsuarioAndPassword(@Valid @RequestBody UsuarioSesionDto usuario, BindingResult bd) {
		ResponseDto response = new ResponseDto();
		if (bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		Usuario usuarios = usuarioRepository.findByNumeroIdentificacionAndPassword(usuario.getUsuario(),
				usuario.getPassword());
		if (usuarios == null) {
			return new ResponseEntity<>(usuarios, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	@PostMapping(value = "/save-usuario")
	private ResponseEntity<ResponseDto> saveUsuario(@Valid @RequestBody UsuarioDTO usuario, BindingResult bd) {

		ResponseDto response = new ResponseDto();
		if (bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
			response.setMensaje(mensaje);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			logger.info("Usuarios {},", usuario.toString());
			Usuario u = new Usuario();
			BeanUtils.copyProperties(usuario, u);
			Timestamp ts=new Timestamp(usuario.getFechaNacimiento().getTime());  
			u.setFechaNacimiento(ts);
			usuarioRepository.save(u);
			response.setMensaje("OK");
		} catch (Exception e) {
			response.setMensaje("Error guardando el usuario " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/remove-usuario/{id}")
	private ResponseEntity<ResponseDto> deleteUsuario(@RequestParam(required = true, name = "id") int id) {
		ResponseDto response = new ResponseDto();
		usuarioRepository.deleteById(id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
