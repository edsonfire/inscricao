package br.com.edson.prime.inscricao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.LocalEvento;

public interface LocalEventoRepository extends JpaRepository<LocalEvento, Integer> {

}
