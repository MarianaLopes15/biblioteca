package br.com.aceleragep.biblioteca.converts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.biblioteca.dtos.inputs.AutorInput;
import br.com.aceleragep.biblioteca.dtos.outputs.AutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;

@Component
public class AutorConvert {

	@Autowired
	private ModelMapper modelMapper;

	public AutorEntity inputToNewEntity(@Valid AutorInput autorInput) {
		return modelMapper.map(autorInput, AutorEntity.class);
	}

	public AutorOutput entityToOutput(AutorEntity autorEntity) {
		return modelMapper.map(autorEntity, AutorOutput.class);
	}

	public void copyInputToEntity(AutorEntity autorEncontrado, @Valid AutorInput autorInput) {
		modelMapper.map(autorInput, autorEncontrado);

	}

	public List<AutorOutput> entityToOutput(List<AutorEntity> autores) {
		return autores.stream().map(autorEntity -> {
			return entityToOutput(autorEntity);
		}).collect(Collectors.toList());
	}
}
