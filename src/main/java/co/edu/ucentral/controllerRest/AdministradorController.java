package co.edu.ucentral.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.repository.IAdministradorRepository;


@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	IAdministradorRepository administradorRepository;
	
	@RequestMapping
	public ResponseEntity<?> getAllAdministrador(){
		
		
		return ResponseEntity.ok(administradorRepository.findAll());
	}
}
