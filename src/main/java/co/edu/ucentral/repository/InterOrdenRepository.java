package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Orden;

public interface InterOrdenRepository extends JpaRepository<Orden, Integer> {

	Orden findByIdOrden(Integer id);
}
