package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Usuario;

public interface IUsuariosRepository extends JpaRepository<Usuario, Long>{

	Usuario findByNumeroIdentificacionAndPassword(Integer numeroIdentificacion, String pass);
}
