package br.com.aceleragep.biblioteca.dtos.inputs;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@NotNull(message = "Titulo é obrigatório!")
	private String titulo;

	@NotNull(message = "Ano Lançamento é obrigatório!")
	private Integer anoLancamento;

	@NotEmpty(message = "Deve ter pelo menos 1 autor!")
	private List<Long> idsAutores;
}
