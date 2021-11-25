package br.com.edson.prime.inscricao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Igreja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private String dirigente;
	
	private String telefone;
	
	private String email;
	
	private String endereco;
	
	private String numero;
	
	private String bairro; 
	
	private String cidade;
	
	private String uf;
	
	
	
	
	
	

}
