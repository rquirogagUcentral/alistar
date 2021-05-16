package co.edu.ucentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Usuario;

public interface InterOrdenRepository extends JpaRepository<Orden, Integer> {

	Orden findByIdOrden(Integer id);
	List<Orden> findByUsuario(Usuario usuario);
}
