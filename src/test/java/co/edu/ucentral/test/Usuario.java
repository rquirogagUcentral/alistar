package co.edu.ucentral.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.ucentral.repository.IUsuariosRepository;

@SpringBootTest
public class Usuario {
	
	@Autowired
	private IUsuariosRepository usuario;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void pruebaUsuario() {
		
		co.edu.ucentral.entidades.Usuario user = usuario.findByNumeroIdentificacion(123456789);
		user.setPassword(encoder.encode("1234"));
		co.edu.ucentral.entidades.Usuario retorno =usuario.save(user);
		
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
				
				
				
	}
	

}
