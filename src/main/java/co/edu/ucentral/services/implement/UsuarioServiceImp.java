package co.edu.ucentral.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.ucentral.dto.UsuarioDTO;
import co.edu.ucentral.entidades.Usuario;
import co.edu.ucentral.repository.IUsuariosRepository;
import co.edu.ucentral.repository.ItelefonoRepository;
import co.edu.ucentral.services.UsuarioService;


@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private IUsuariosRepository usuarioRepository;
	

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
	public UsuarioDTO  getUsurioBypasword(Integer id, String clave) {
		UsuarioDTO usuarioDto=null;
		Usuario usuario = usuarioRepository.findByNumeroIdentificacionAndPassword(id,clave);
		if(usuario !=null) {
			usuarioDto= covertToDto(usuario);
		}
		
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

	@Override
	public UserDetails loadUserByUsername(Integer usuario) {
		Usuario usuarioTemp = usuarioRepository.findByNumeroIdentificacion(usuario);
		List<GrantedAuthority>  roles= new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDet  = new User(usuarioTemp.getNumeroIdentificacion().toString(),usuarioTemp.getPassword(), roles); 
		return userDet;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuarioTemp = usuarioRepository.findByNumeroIdentificacion(Integer.parseInt(username));
		List<GrantedAuthority>  roles= new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDet  = new User(usuarioTemp.getNumeroIdentificacion().toString(),usuarioTemp.getPassword(), roles); 
	
		return userDet;
	}
}
