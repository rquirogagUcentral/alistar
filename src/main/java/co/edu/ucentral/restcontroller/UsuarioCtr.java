package co.edu.ucentral.restcontroller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

import co.edu.ucentral.JwtUtil.UtilJwt;
import co.edu.ucentral.dto.RespuestaGenerica;
import co.edu.ucentral.dto.RespuestaToken;
import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.dto.UsuarioSesionDto;
import co.edu.ucentral.exception.HandleValidationExceptions;
import co.edu.ucentral.exception.MessageError;
import co.edu.ucentral.services.UsuarioService;

@RestController
@RequestMapping(path = "/Usuarios")
public class UsuarioCtr {

	private static Logger logger = LoggerFactory.getLogger(UsuarioCtr.class);

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UtilJwt jwtTokenUtil;

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
		RespuestaGenerica response = new RespuestaGenerica();
		if (bd.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatoMensaje(bd));
		}
		UsuarioDTO usuario = usuarioService.getUsurioBypasword(usuarioDto.getUsuario(), usuarioDto.getPassword());

		if (usuario == null) {
			response.setCodigo(404);
			response.setResponse("Usuario no encontrado");
			return ResponseEntity.status(404).body(response);
		}
		return ResponseEntity.ok(usuario);

	}

	@PostMapping(value = "/save-usuario")
	private ResponseEntity<?> saveUsuario(@Valid @RequestBody UsuarioDTO usuariodto, BindingResult bd) {
		RespuestaGenerica generica = new RespuestaGenerica();
		if (bd.hasErrors()) {
			logger.error("Erorr al validar el formulario {}", this.formatoMensaje(bd));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatoMensaje(bd));
		}
		if (usuarioService.validaUsuario(usuariodto)) {
			UsuarioDTO usuario = usuarioService.updateUsuario(usuariodto);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		} else {
			generica.setCodigo(304);
			generica.setResponse("El usuario ya existe");
			return ResponseEntity.status(304).body(generica);
		}
	}

	@DeleteMapping(value = "/remove-usuario")
	private ResponseEntity<?> deleteUsuario(@RequestParam(required = true, name = "id") Integer id) {
		RespuestaGenerica generica = new RespuestaGenerica();
		try {
			usuarioService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			
			logger.error("Error en el borrado del usuario ", e.getMessage());
			generica.setCodigo(304);
			generica.setResponse("no existe");
			return ResponseEntity.status(304).body(generica);
		}

		

	}

	@PostMapping(value = "/autenticacion")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UsuarioSesionDto usuarioDto) throws Exception {

		RespuestaToken respuesta = new RespuestaToken();
		try {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(usuarioDto.getUsuario(), usuarioDto.getPassword()));
			} catch (BadCredentialsException e) {
				logger.error("fallo en el metodo de utentificacion{}", e.getMessage());
				logger.error("Errer al loguear {} ", e.getMessage());
				respuesta.setCodigo(404);
				respuesta.setResponse("token no generado");
				return ResponseEntity.status(404).body(respuesta);
				// throw new Exception("Incorrect username or password", e);

			}
			final UserDetails userDetails = usuarioService.loadUserByUsername(usuarioDto.getUsuario());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			respuesta.setCodigo(0);
			respuesta.setResponse("Token generado");
			respuesta.setToken(jwt);

			logger.info("Objeto Respuesta", respuesta);

		} catch (Exception e) {
			logger.error("Errer al loguear {} ", e.getMessage());
			respuesta.setCodigo(404);
			respuesta.setResponse("token no generado");
			return ResponseEntity.status(404).body(respuesta);
		}
		return ResponseEntity.ok(respuesta);

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
