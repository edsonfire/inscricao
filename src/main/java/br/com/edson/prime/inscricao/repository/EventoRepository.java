package br.com.edson.prime.inscricao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
