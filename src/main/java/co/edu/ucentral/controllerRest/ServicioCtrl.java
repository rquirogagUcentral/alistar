package co.edu.ucentral.controllerRest;

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

import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.dto.ServicioDTO;
import co.edu.ucentral.repository.IServiciosRepository;
import co.edu.ucentral.services.ServicesServicio;

@RestController
@RequestMapping(path  = "/Servicio")
public class ServicioCtrl {

	private static Logger logger = LoggerFactory.getLogger(ServicioCtrl.class);
	@Autowired
	private ServicesServicio serviceServicio;
	
	
	@GetMapping()
	private  ResponseEntity<?> getServices(){
		logger.info("Se obtiene la cantidad de servicios");
		List<ServicioDTO> servicio =serviceServicio.AllServicio();
		if(servicio.isEmpty())
			return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new  ResponseEntity<>(servicio, HttpStatus.OK);
	}
	@PostMapping(path = "/save-Servicio")
	public  ResponseEntity<?> saveServicio(@Valid @RequestBody ServicioDTO servicio,BindingResult bd){
		ResponseDto response = new ResponseDto();
		
		try {
			if (bd.hasErrors()) {
				String mensaje = bd.getFieldError().toString();
				response.setMensaje(mensaje);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			response.setMensaje("Error en el guardado de Servicio");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PutMapping(path = "/{id}")
	public  ResponseEntity<?> modificar(@RequestParam(required = true, name = "id") int id,@Valid @RequestBody ServicioDTO servicio,BindingResult bd){
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping(path = "/delete-Servicio/{id}")
	public  ResponseEntity<?> eliminarServicio(@RequestParam(required = true, name = "id") int id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
