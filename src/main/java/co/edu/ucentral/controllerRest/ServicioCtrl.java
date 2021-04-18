package co.edu.ucentral.controllerRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.repository.IServiciosRepository;

@RestController
@RequestMapping(path  = "/Servicio")
public class ServicioCtrl {

	private static Logger logger = LoggerFactory.getLogger(ServicioCtrl.class);
	@Autowired
	private IServiciosRepository servicioRepository;
	
	
	@GetMapping()
	private  ResponseEntity<?> getServices(){
		logger.info("Se obtiene la cantidad de servicios");
		return new  ResponseEntity<>(servicioRepository.findAll(), HttpStatus.OK);
	}
}
