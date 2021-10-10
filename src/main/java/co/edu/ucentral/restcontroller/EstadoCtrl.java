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
import org.springframework.web.server.ResponseStatusException;

import co.edu.ucentral.dto.EstadoDTO;
import co.edu.ucentral.services.EstadoService;
import co.edu.ucentral.util.MensajeFormat;

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
		if (bd.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, new MensajeFormat().formatoMensaje(bd));
		} else {
			try {
				EstadoDTO respose = estadoService.createEstate(estado);
				return new ResponseEntity<>(respose, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			}
		}
		
	}

}
