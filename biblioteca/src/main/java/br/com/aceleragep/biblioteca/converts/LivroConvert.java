package br.com.aceleragep.biblioteca.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.biblioteca.dtos.inputs.LivroInput;
import br.com.aceleragep.biblioteca.dtos.outputs.LivroOutput;
import br.com.aceleragep.biblioteca.dtos.outputs.LivroAutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.services.AutorService;

@Component
public class LivroConvert {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AutorService autorService;

	public LivroEntity inputToNewEntity(@Valid LivroInput livroInput) {
		LivroEntity livroEntity = modelMapper.map(livroInput, LivroEntity.class);
		converteIdsAutorParaAutores(livroInput, livroEntity);
		return livroEntity;
	}

	public LivroOutput entityToOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroOutput.class);
	}

	public void copyInputToEntity(LivroEntity livroLocalizado, @Valid LivroInput livroInput) {
		modelMapper.map(livroInput, livroLocalizado);
		converteIdsAutorParaAutores(livroInput, livroLocalizado);

	}

	public List<LivroOutput> entityToOutput(List<LivroEntity> livrosLocalizados) {
		return livrosLocalizados.stream().map(livroEntity -> {
			return entityToOutput(livroEntity);
		}).collect(Collectors.toList());
	}

	private void converteIdsAutorParaAutores(LivroInput livroInput, LivroEntity livroEntity) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getIdsAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
	}

	public LivroAutorOutput entityToSemAutorOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroAutorOutput.class);
	}

	public List<LivroAutorOutput> entityToSemAutorOutput(List<LivroEntity> livros) {
		return livros.stream().map(livroEntity -> {
			return entityToSemAutorOutput(livroEntity);
		}).collect(Collectors.toList());
	}

}
