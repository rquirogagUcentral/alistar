package co.edu.ucentral.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.ucentral.entidades.TiposDocumento;
import co.edu.ucentral.repository.ITipoDocumentoRepository;

@SpringBootTest
public class TiposDocumentoTest {

	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	@Test
	void crearUsuarioTest() {
		TiposDocumento tipoDocumento= new TiposDocumento();
		tipoDocumento.setDescripcionCorta("CE");
		tipoDocumento.setDescripcionLarga("Cedula de Extranjeria");
		TiposDocumento retorno=tipoDocumentoRepository.save(tipoDocumento);
		assertTrue(retorno.getDescripcionCorta().equalsIgnoreCase("CE"));
		
	}

}
