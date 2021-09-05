package co.edu.ucentral.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.dto.RespuestaGenerica;
import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.entidades.Servicio;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.services.ServicesServicio;
import co.edu.ucentral.util.MensajeFormat;

@RestController
@RequestMapping(path = "/Servicio")
public class ServicioCtrl {

	private static Logger logger = LoggerFactory.getLogger(ServicioCtrl.class);
	@Autowired
	private ServicesServicio serviceServicio;

	
	
	@GetMapping()
	private ResponseEntity<?> getServices() {
		logger.info("Se obtiene la cantidad de servicios");
		List<ServicioDTO> servicio = serviceServicio.AllServicio();
		if (servicio.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(servicio, HttpStatus.OK);
	}

	@GetMapping(params = "id")
	public ResponseEntity<?> buscarById(@RequestParam(required = true, name = "id") int id) {
		ResponseDto response = new ResponseDto();
		try {

			ServicioDTO servicio = serviceServicio.getByIdServicio(null, id);
			if (servicio == null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(servicio, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/save-Servicio")
	public ResponseEntity<?> saveServicio(@Valid @RequestBody ServicioDTO servicio, BindingResult bd) {
		RespuestaGenerica response = new RespuestaGenerica();
		logger.info("@@@ servicio => {}",servicio.toString());
		try {
			if (bd.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,new MensajeFormat().formatoMensaje(bd));
			}
			serviceServicio.getServio(servicio);
			
		} catch (Exception e) {
			logger.error("Error : {}" , e.getMessage());
			
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/modify")
	public ResponseEntity<?> modificar(@Valid @RequestBody ServicioDTO servicio, BindingResult bd) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete-Servicio", params = "id")
	public ResponseEntity<?> eliminarServicio(@RequestParam(required = true, name = "id") int id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping(path = "get-usuario-service", params =  "usuarioId")
	public  ResponseEntity<?> getUsuariSerbice(@RequestParam(required = true , name = "usuarioId") int usuarioId){
		List<ServicioDTO> listadoServicio=serviceServicio.getByIdUsuario(usuarioId);
		ResponseDto response = new ResponseDto();
		if(listadoServicio.isEmpty()) {
			//response.setMensaje("NO se encuentra el usuario");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else
			return new ResponseEntity<>(listadoServicio,HttpStatus.OK);
	}

}
