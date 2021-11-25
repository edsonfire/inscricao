package br.com.edson.prime.inscricao.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscricaoDTO {

	
	private Long id;
	@NotEmpty(message = "informe o nome")
	private String nome;
	@Email(message = "Informe um email, válido")
	private String email;
	
	private String mae;
	
	private String pai;
	
	private int idade;
	
	private DepartamentoEnum departamento;
	
	private String telefone;
	
	
	
	public InscricaoDTO(Inscricao insc) {
		
		this.id = insc.getId();
		this.nome = insc.getNome();
		this.email = insc.getEmail();
		this.mae = insc.getMae();
		this.pai = insc.getPai();
		this.idade = insc.getIdade();
		this.departamento = insc.getDepartamento();
		this.telefone = insc.getTelefone();
	}
	
}
