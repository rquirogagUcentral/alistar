package co.edu.ucentral.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.services.ServicesOrden;

@RestController
@RequestMapping(path = "/Orden")
public class OrdenCtrl {


	@Autowired
	private ServicesOrden ordenService;
	
	@GetMapping(path = "/getIdOrden",params  = "id")
	private ResponseEntity<?> getByIdOrden(@RequestParam(required = true,value = "id") int id){
		OrdenDTO ordenDto =ordenService.getOrden(id);
		
		return new ResponseEntity(ordenDto,HttpStatus.OK);
	}
	@GetMapping()
	private ResponseEntity<?> getByIdOrden(){
	   List<OrdenDTO> Listadoorden = ordenService.listadoOrden();
		
		return new ResponseEntity(Listadoorden,HttpStatus.OK);
	}
	
	@PostMapping(path = "/save-Orden")
	private ResponseEntity<?> saveOrden(@RequestBody OrdenDTO ordendto){
		OrdenDTO orden  =  ordenService.updateOrden(ordendto);
		return new ResponseEntity<>(orden,HttpStatus.OK);
	}
}
