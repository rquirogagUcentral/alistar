package co.edu.ucentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Direccion;
import co.edu.ucentral.entidades.Servicio;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
	
	List<Direccion> findByServicio(Servicio servicio);

}
