package br.com.edson.prime.inscricao.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
	private int id;
	private String name;
	private String username;
	private String type;
	private String token;

}