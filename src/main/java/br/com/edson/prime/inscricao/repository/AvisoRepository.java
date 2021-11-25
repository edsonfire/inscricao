package br.com.edson.prime.inscricao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Integer> {

}
