package br.com.edson.prime.inscricao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.prime.inscricao.model.InscricaoDTO;
import br.com.edson.prime.inscricao.service.InscricaoService;
import br.com.edson.prime.inscricao.util.Message;

@RestController
@RequestMapping("/inscricao/api")
public class InscricaoController {
	
	@Autowired
	private InscricaoService inscricaoService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<InscricaoDTO>> getAll(){
		
		return ResponseEntity.ok().body(inscricaoService.getAll());
		
	}
	
	
	@PostMapping
	public ResponseEntity<?> create( @RequestBody InscricaoDTO dto){
		
		

			InscricaoDTO  dtoResponse = inscricaoService.save(dto);
		if(dtoResponse!=null && dtoResponse.getId()>0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					Message.builder()
					.mensagem("falha ao realizar a operação, email já cadastrado").build()
					);
		}
		
		
		
		
	}
	

}
