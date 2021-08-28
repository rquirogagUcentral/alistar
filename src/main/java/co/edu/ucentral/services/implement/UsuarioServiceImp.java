package co.edu.ucentral.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Telefono;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.repository.ItelefonoRepository;
import co.edu.ucentral.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private IUsuariosRepository usuarioRepository;
	@Autowired 
	private ItelefonoRepository telefonoRepository;

	@Override
	public List<UsuarioDTO> listadoUsuarios() {
		return usuarioRepository.findAll().stream().map(this::covertToDto).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO usuario(Integer id) {
		Usuario usuario = usuarioRepository.findByNumeroIdentificacion(id);
		UsuarioDTO usuarioDto= covertToDto(usuario);
		return usuarioDto;
	}

	@Override
	public UsuarioDTO getUsurioBypasword(Integer id, String clave) {
		Usuario usuario = usuarioRepository.findByNumeroIdentificacionAndPassword(id,clave);
		UsuarioDTO usuarioDto= covertToDto(usuario);
		return usuarioDto;
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario= convertToEntity(usuarioDto);
		usuario  =  usuarioRepository.save(usuario);
		usuarioDto = covertToDto(usuario);
		return usuarioDto;
	}

	private Usuario convertToEntity(UsuarioDTO usuarioDto) {
		ModelMapper modelMapper=new ModelMapper(); 
		Usuario usaurio =modelMapper.map(usuarioDto, Usuario.class);
		Telefono telefono = telefonoRepository.findByTelefono(usaurio.getTelefono().getTelefono());
		if(telefono!=null) {
			usaurio.setTelefono(telefono);		
		}
		
		return usaurio;
	}

	@Override
	public void deleteById(Integer id) {
		 usuarioRepository.deleteById(id);
	}
	private UsuarioDTO covertToDto(Usuario usurario) {
		ModelMapper modelMapper=new ModelMapper(); 
		UsuarioDTO usuDto =  modelMapper.map(usurario,UsuarioDTO.class);
		return usuDto ;
	}
}
