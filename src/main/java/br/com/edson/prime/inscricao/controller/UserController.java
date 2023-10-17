package br.com.edson.prime.inscricao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.prime.inscricao.model.Usuario;
import br.com.edson.prime.inscricao.repository.UserRepository;
import br.com.edson.prime.inscricao.service.UserService;

@RestController
@RequestMapping("/auth/api/user")
public class UserController {
	
	
	
	@Autowired
	UserService service;
	
	
	@PostMapping
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usr){
		
	  Usuario user = service.save(usr);
	  
	  return ResponseEntity.ok().body(user);
		
		
	}

	
	
	@PutMapping
	public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usr){
		
	  Usuario user = service.save(usr);
	  
	  return ResponseEntity.ok().body(user);
		
		
	}
	
	
	
}
