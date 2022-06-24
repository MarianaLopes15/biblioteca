package br.com.aceleragep.biblioteca.dtos.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@NotBlank(message = "Nome é obrigatório!")
	private String nome;

	@Length(max = 1000)
	@NotBlank(message = "Bibliografia é obrigatória!")
	private String bibliografia;
}