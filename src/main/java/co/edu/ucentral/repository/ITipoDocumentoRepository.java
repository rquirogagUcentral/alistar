package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.TiposDocumento;

public interface ITipoDocumentoRepository extends JpaRepository<TiposDocumento, Integer> {

}
