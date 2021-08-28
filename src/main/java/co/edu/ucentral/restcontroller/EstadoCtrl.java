package co.edu.ucentral.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.services.EstadoService;

@RestController
@RequestMapping(path = "/estado")
public class EstadoCtrl {

	private static Logger logger = LoggerFactory.getLogger(EstadoCtrl.class);
	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public ResponseEntity<?> getEstados() {

		logger.info("Se obtiene la cantidad de servicios");
		List<EstadoDTO> estado = estadoService.listadoService();
		if (estado.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(estado, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<?> saveEstado(@Valid @RequestBody EstadoDTO estado,BindingResult bd) {
		ResponseDto response = new ResponseDto();
		if (bd.hasErrors()) {
			String mensaje = bd.getFieldError().toString();
	//		response.setMensaje(mensaje);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			try {
				EstadoDTO respose = (EstadoDTO) estadoService.crearServicio(estado);
		//		response.setMensaje("OK");
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} catch (Exception e) {
	//			response.setMensaje("Error creado el servicio");
				return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
			}
		}
		
	}

}
