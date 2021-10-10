package co.edu.ucentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.entidades.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

	Horario findByIdHorario(Integer idHorario);
}
