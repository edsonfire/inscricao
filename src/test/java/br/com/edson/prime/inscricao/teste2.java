package br.com.edson.prime.inscricao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.edson.prime.inscricao.repository.InscricaoRepository;

class teste2 {

	@Autowired
	private InscricaoRepository repository;
	
	
	@Test
	void test() {
			Assert.notEmpty(repository.findAll());
	}

}
