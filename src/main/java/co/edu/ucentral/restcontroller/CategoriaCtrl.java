package co.edu.ucentral.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.edu.ucentral.dto.CategoriaDTO;
import co.edu.ucentral.dto.ResponseDto;
import co.edu.ucentral.entidades.Categoria;
import co.edu.ucentral.exception.HandleValidationExceptions;
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
	public ResponseEntity<?> saveCategoria(@Validated @RequestBody CategoriaDTO categoria, BindingResult bd){

		if (bd.hasErrors()) {
			logger.info("binding {}");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(bd));
		} else {
			logger.info("@ @ =>> categorias => {},", categoria.toString());
			Categoria c = new Categoria();
			BeanUtils.copyProperties(categoria, c);
			Categoria cat =categoriaRepository.save(c);
			CategoriaDTO categoriadto =new CategoriaDTO();
			BeanUtils.copyProperties(cat, categoriadto);
			
			return new ResponseEntity<>(categoriadto, HttpStatus.CREATED);
		}
	}

	@DeleteMapping(path = "/delete-categoria", params = "id")
	private ResponseEntity<?> deleteCategoria(@RequestParam(required = true, value = "id") int id) {
		categoriaRepository.deleteById(id);
		boolean deleteCategoria = categoriaRepository.existsById(id);
		return new ResponseEntity<>(!deleteCategoria, HttpStatus.OK);
	}

	public String formatMessage(BindingResult bd) {
		List<Map<String, String>> errors =  bd.getFieldErrors().stream().map(err -> {
			Map<String, String> error =new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());
		ResponseDto response =new  ResponseDto();
		response.setMensaje(errors);
		logger.info("prueba {} ",response.getMensaje().toArray());
		return response.toString();
	}	

}
