package br.com.edson.prime.inscricao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InscricaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscricaoApplication.class, args);
	}
	
	


}
