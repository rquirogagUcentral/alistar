package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Administrador;

public interface IAdministradorRepository extends JpaRepository<Administrador, Long>{

	Administrador findByNombreadminAndContrasenia(String nombre , String contrasenia );
}
