package co.edu.ucentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Evento;
import co.edu.ucentral.entidades.Orden;
import co.edu.ucentral.entidades.Usuario;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {

	List<Evento> findByOrden(Orden orden);
	Evento findByIdEvento(Integer id);
	List<Evento> findByUsuario(Usuario usuario);

}
