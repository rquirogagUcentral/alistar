package co.edu.ucentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Categoria;
import co.edu.ucentral.entidades.Servicio;

public interface ICaegoriaRepository extends JpaRepository<Categoria, Integer> {

	List<Categoria> findByServicio(Servicio servicio);
}
