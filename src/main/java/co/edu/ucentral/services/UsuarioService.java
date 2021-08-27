package co.edu.ucentral.services;

import java.util.List;

import co.edu.ucentral.dto.UsuarioDTO;

public interface UsuarioService {

	List<UsuarioDTO> listadoUsuarios();
	UsuarioDTO usuario(Integer id);
	UsuarioDTO getUsurioBypasword(Integer id, String clave);
	UsuarioDTO updateUsuario(UsuarioDTO usuarioDto);
	
}
