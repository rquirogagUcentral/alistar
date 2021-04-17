package co.edu.ucentral.controllerRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.repository.IServiciosRepository;

@RestController
@RequestMapping(value = "/api")
public class ServicioCtrl {

	private static Logger logger = LoggerFactory.getLogger(ServicioCtrl.class);
	@Autowired
	private IServiciosRepository servicioRepository;
	
	
	@RequestMapping(value = "getServices")
	private  ResponseEntity<?> getServices(){
		return new  ResponseEntity<>(servicioRepository.findAll(), HttpStatus.OK);
	}
}
