package br.com.edson.prime.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
	
	
	Optional<Inscricao> findByEmail(String email);

}
