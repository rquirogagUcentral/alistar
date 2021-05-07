package co.edu.ucentral.controllerRest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.dto.CategoriaDTO;
import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.entidades.Categoria;
import co.edu.ucentral.repository.ICaegoriaRepository;

@RestController
@RequestMapping(path = "/Categoria")
public class CategoriaCtrl {

	private static Logger logger = LoggerFactory.getLogger(CategoriaCtrl.class);
	@Autowired
	private ICaegoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<?> getAllCategorias() {
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		return new ResponseEntity<>(listaCategoria, HttpStatus.OK);
	}

	@PostMapping(path = "/save-categoria")
	public ResponseEntity<?> saveCategoria(@Valid @RequestBody CategoriaDTO categoria, BindingResult bd) {

		ResponseDto response = new ResponseDto();
		try {

			if (bd.hasErrors()) {
				String mensaje = bd.getFieldError().toString();
				response.setMensaje(mensaje);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			logger.info("@ @ =>> categorias => {},", categoria.toString());
			Categoria c = new Categoria();
			BeanUtils.copyProperties(categoria,c);
			categoriaRepository.save(c);
			
		} catch (Exception e) {
			response.setMensaje("Error guardando el usuario " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<>(categoria, HttpStatus.CREATED);
	}
	@DeleteMapping(path = "/delete-categoria" ,params = "id")
	private ResponseEntity<?> deleteCategoria(@RequestParam(required = true,value = "id") int id){
		 categoriaRepository.deleteById(id);
		 boolean deleteCategoria =categoriaRepository.existsById(id);
		return new ResponseEntity<>(!deleteCategoria, HttpStatus.OK);
	}
}
