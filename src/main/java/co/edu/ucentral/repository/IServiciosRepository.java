package co.edu.ucentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Servicio;

public interface IServiciosRepository extends JpaRepository<Servicio,Integer>{
	
	Servicio findByIdServicio(Integer idServicio);
	List<Servicio> findByProveedor(Integer proveedor);

}
