package co.edu.ucentral.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.edu.ucentral.dto.OrdenDTO;
import co.edu.ucentral.services.OrdenServices;
import co.edu.ucentral.util.MensajeFormat;

@RestController
@RequestMapping(path = "/Orden")
public class OrdenCtrl {


	@Autowired
	private OrdenServices ordenService;
	
	@GetMapping(path = "/getIdOrden",params  = "id")
	private ResponseEntity<?> getByIdOrden(@RequestParam(required = true,value = "id") int id){
		OrdenDTO ordenDto =ordenService.OrdenByOrden(id);
		
		return new ResponseEntity<>(ordenDto,HttpStatus.OK);
	}
	@GetMapping()
	private ResponseEntity<?> getByIdOrden(){
	   List<OrdenDTO> Listadoorden = ordenService.listOrden();
		
		return new ResponseEntity<>(Listadoorden,HttpStatus.OK);
	}
	
	@PostMapping(path = "/save-Orden")
	private ResponseEntity<?> saveOrden(@Valid @RequestBody OrdenDTO ordendto, BindingResult bd){
		if(bd.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, new MensajeFormat().formatoMensaje(bd));
		}
		OrdenDTO orden  =  ordenService.createOrden(ordendto);
		return new ResponseEntity<>(orden,HttpStatus.OK);
	}
}
