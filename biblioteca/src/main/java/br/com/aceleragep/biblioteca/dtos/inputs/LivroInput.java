package br.com.aceleragep.biblioteca.dtos.inputs;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@Length(max = 200)
	@NotBlank(message = "Titulo é obrigatório!")
	private String titulo;

	@DecimalMax("9999")
	@NotNull(message = "Ano Lançamento é obrigatório!")
	private Integer anoLancamento;

	@NotEmpty(message = "Deve ter pelo menos 1 autor!")
	private List<Long> idsAutores;
}
