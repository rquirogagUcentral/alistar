package co.edu.ucentral.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Usuario;

public interface UsuarioService extends UserDetailsService {

	List<UsuarioDTO> listadoUsuarios();
	UsuarioDTO usuario(Integer id);
	Usuario usuarioById(Integer id);
	UserDetails loadUserByUsername(Integer usuario);
	UsuarioDTO getUsurioBypasword(Integer id, String clave);
	UsuarioDTO updateUsuario(UsuarioDTO usuarioDto);
	void deleteById(Integer id);
	boolean validaUsuario(UsuarioDTO usuarioDto);
}
