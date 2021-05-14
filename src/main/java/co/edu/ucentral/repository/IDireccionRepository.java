package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Direccion;
import co.edu.ucentral.entidades.Servicio;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
	
	Direccion findByServicio(Servicio servicio);

}
