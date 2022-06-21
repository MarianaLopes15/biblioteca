package br.com.aceleragep.biblioteca.dtos.inputs;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@NotNull(message = "Nome é obrigatório!")
	private String nome;

	@NotNull(message = "Bibliografia é obrigatória!")
	private String bibliografia;
}