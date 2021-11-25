package br.com.edson.prime.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Igreja;

public interface IgrejaRepository extends JpaRepository<Igreja, Long> {

	
	Optional<Igreja> findByDescricao(String descricao);
	
}
