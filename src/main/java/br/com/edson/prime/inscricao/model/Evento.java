package br.com.edson.prime.inscricao.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	private String descricao;
	  @JsonFormat(
    	      shape = JsonFormat.Shape.STRING,
    	      pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private String responsavel;
	
	private String resumo;
	
	private String banner1;
	
	private String banner2;
	
	private int ativo;

}
