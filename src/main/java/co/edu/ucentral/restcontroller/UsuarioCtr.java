package co.edu.ucentral.restcontroller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.dto.UsuarioSesionDto;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.exception.MessageError;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.services.UsuarioService;

@RestController
@RequestMapping(path = "/Usuarios")
public class UsuarioCtr {

	private static Logger logger = LoggerFactory.getLogger(UsuarioCtr.class);
	@Autowired
	private IUsuariosRepository usuarioRepository;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	private ResponseEntity<?> getUsuario() throws SQLException {

		List<UsuarioDTO> listaUsuario = usuarioService.listadoUsuarios();
		if (listaUsuario.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listaUsuario);
	}

	@PostMapping(value = "/getUsuario-password")
	private ResponseEntity<?> getUsuarioAndPassword(@Valid @RequestBody UsuarioSesionDto usuarioDto, BindingResult bd) {
		if (bd.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatoMensaje(bd));
		}
		UsuarioDTO usuario = usuarioService.getUsurioBypasword(usuarioDto.getUsuario(), usuarioDto.getPassword());

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);

	}

	@PostMapping(value = "/save-usuario")
	private ResponseEntity<?> saveUsuario(@Valid @RequestBody UsuarioDTO usuariodto, BindingResult bd) {

		if (bd.hasErrors()) {
			logger.error("Erorr al validar el formulario {}", this.formatoMensaje(bd));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatoMensaje(bd));
		}
		UsuarioDTO usuario = usuarioService.updateUsuario(usuariodto);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	@DeleteMapping(value = "/remove-usuario/{id}")
	private ResponseEntity<?> deleteUsuario(@RequestParam(required = true, name = "id") int id) {
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	private String formatoMensaje(BindingResult resutl) {
		List<Map<String, String>> error = resutl.getFieldErrors().stream().map(err -> {
			Map<String, String> er = new HashMap<>();
			er.put(err.getField(), err.getDefaultMessage());
			return er;
		}).collect(Collectors.toList());
		MessageError errorMensaje = new MessageError(0, error);
		ObjectMapper maper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = maper.writeValueAsString(errorMensaje);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonString;
	}
}
