package br.com.aceleragep.biblioteca.dtos.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@Length(max = 100)
	@NotBlank(message = "Nome é obrigatório!")
	private String nome;

	@Length(max = 1000)
	@NotBlank(message = "Biografia é obrigatória!")
	private String biografia;
}