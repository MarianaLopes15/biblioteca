package br.com.aceleragep.biblioteca.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroAutorOutput {
	private Long id;

	private String titulo;

	private Integer anoLancamento;
}