package br.com.edson.prime.inscricao.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Departamento;
import br.com.edson.prime.inscricao.model.Evento;
import br.com.edson.prime.inscricao.model.LocalEvento;
import br.com.edson.prime.inscricao.model.PeriodoEnum;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
	Optional<List<Evento>> findByDataAndPeriodo(LocalDate data, PeriodoEnum periodoEnum);
	Optional<List<Evento>>  findByDataAndPeriodoAndLocalEvento(LocalDate data, PeriodoEnum periodoEnum, LocalEvento localEvento);
	Optional<List<Evento>> findByDepartamento(Departamento dp);
 
}
