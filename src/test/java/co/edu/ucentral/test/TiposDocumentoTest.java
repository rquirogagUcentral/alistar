package co.edu.ucentral.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		tipoDocumento.setDescripcionCorta("CC");
		tipoDocumento.setDescripcionLarga("Cedula de Ciudadania");
		TiposDocumento retorno=tipoDocumentoRepository.save(tipoDocumento);
		assertTrue(retorno.getDescripcionCorta().equalsIgnoreCase("CC"));	
	}

	@Test
	void seleccionarTipoDocumentoTest() {
		TiposDocumento tipoDocumento = tipoDocumentoRepository.getOne(1);
		assertEquals(tipoDocumento.getTipoDocumento(), 1);
	}
}
