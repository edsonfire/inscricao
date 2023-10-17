package br.com.edson.prime.inscricao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.prime.inscricao.model.Departamento;
import br.com.edson.prime.inscricao.model.LocalEvento;
import br.com.edson.prime.inscricao.service.LocalEventoService;
import br.com.edson.prime.inscricao.util.Message;


@RestController
@RequestMapping("/adtag/api/localevento")
public class LocalEventoController {

	@Autowired
	private LocalEventoService service;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<LocalEvento>> getAll(){
		
		return ResponseEntity.ok().body(service.getAll());
		
	}
	
	
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody LocalEvento dto){
		
		

			LocalEvento dtoResponse = service.save(dto);
		if(dtoResponse.getId()>0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					Message.builder()
					.mensagem("falhao ao realizar a operação").build()
					);
		}
		
		
		
		
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody LocalEvento dto){
		
		
		if(dto.getId()>0) {
			LocalEvento m = service.update(dto);
			
			if(m.getId()>0) {
				
				return ResponseEntity.ok().body(m);
			}else {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
							Message.builder()
							.mensagem("Operação não realizada").build()
							);
			}
			
			
		}else {
			
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					Message.builder()
					.mensagem("LocalEvento inválido").build()
					);
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		if(	service.delete(id)) {

			 return ResponseEntity.status(HttpStatus.OK).body(
					Message.builder()
					.mensagem("Excuído com sucesso!").build()
					);
		}else {
			

			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					Message.builder()
					.mensagem("Falha ao realizar a operação!").build()
					);
		}
		
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable int id) {

		LocalEvento a = service.getById(id);

		if (a != null) {
			return ResponseEntity.ok(a);
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Message.builder().mensagem("Falha ao realizar a operação!").build());
		}

	}
	

}
