package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Telefono;

public interface ItelefonoRepository extends JpaRepository<Telefono, Integer> {

	Telefono findByTelefono(String telefono);
}
