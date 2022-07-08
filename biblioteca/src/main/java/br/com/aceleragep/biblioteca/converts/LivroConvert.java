package br.com.aceleragep.biblioteca.converts;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.aceleragep.biblioteca.dtos.inputs.LivroInput;
import br.com.aceleragep.biblioteca.dtos.outputs.LivroAutorOutput;
import br.com.aceleragep.biblioteca.dtos.outputs.LivroOutput;
import br.com.aceleragep.biblioteca.entities.LivroEntity;

@Component
public class LivroConvert {

	@Autowired
	private ModelMapper modelMapper;

	public LivroEntity inputToNewEntity(@Valid LivroInput livroInput) {
		LivroEntity livroEntity = modelMapper.map(livroInput, LivroEntity.class);
		return livroEntity;
	}

	public LivroOutput entityToOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroOutput.class);
	}

	public Page<LivroOutput> listPageEntityToListPageOutput(Page<LivroEntity> livrosLocalizados) {
		return livrosLocalizados.map(this::entityToOutput);
	}

	public void copyInputToEntity(LivroEntity livroLocalizado, @Valid LivroInput livroInput) {
		modelMapper.map(livroInput, livroLocalizado);
	}

	public LivroAutorOutput entityToSemAutorOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroAutorOutput.class);
	}

	public Page<LivroAutorOutput> listPageEntityToListPageOutputCopy(Page<LivroEntity> livros) {
		return livros.map(this::entityToSemAutorOutput);
	}

}
