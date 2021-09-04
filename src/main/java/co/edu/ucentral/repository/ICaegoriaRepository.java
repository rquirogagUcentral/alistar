package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Categoria;

public interface ICaegoriaRepository extends JpaRepository<Categoria, Integer> {
	Categoria findByIdCategoria(Integer idCategoria);
}
