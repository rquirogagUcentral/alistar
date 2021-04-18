package co.edu.ucentral.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.entidades.TiposDocumento;
import co.edu.ucentral.repository.ITipoDocumentoRepository;

@RestController
@RequestMapping(path = "TiposDocumentos")
public class TipoDocumentoCtr {

	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepo;
	
	@GetMapping()
	public ResponseEntity<?> getAllTiposDocumento(){
		List<TiposDocumento> tipoDocu =tipoDocumentoRepo.findAll();
		return new ResponseEntity<>(tipoDocu,HttpStatus.OK);
	}
}
