package br.com.edson.prime.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edson.prime.inscricao.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
	
	
  Optional<Usuario> findByUsername(String username);

}
