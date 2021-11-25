package br.com.edson.prime.inscricao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscricao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String mae;
	
	private String pai;
	
	private int idade;
	
	private DepartamentoEnum departamento;
	
	private String telefone;

	public Inscricao(InscricaoDTO dto) {
	
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.email = dto.getEmail();
		this.mae = dto.getMae();
		this.pai = dto.getPai();
		this.idade = dto.getIdade();
		this.departamento = dto.getDepartamento();
		this.telefone = dto.getTelefone();
	}
	
	

	
	
	

}
