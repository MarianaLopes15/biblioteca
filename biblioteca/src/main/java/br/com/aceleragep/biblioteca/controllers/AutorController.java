package br.com.aceleragep.biblioteca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.biblioteca.configs.ControllerConfig;
import br.com.aceleragep.biblioteca.converts.AutorConvert;
import br.com.aceleragep.biblioteca.converts.LivroConvert;
import br.com.aceleragep.biblioteca.dtos.inputs.AutorInput;
import br.com.aceleragep.biblioteca.dtos.outputs.AutorOutput;
import br.com.aceleragep.biblioteca.dtos.outputs.LivroAutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.services.AutorService;
import br.com.aceleragep.biblioteca.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@Autowired
	private AutorConvert autorConvert;

	@Autowired
	private LivroService livroService;

	@Autowired
	private LivroConvert livroConvert;

	@Operation(parameters = {
			@Parameter(in = ParameterIn.QUERY, description = "Paginas a ser carregada", name = "page", content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))),
			@Parameter(in = ParameterIn.QUERY, description = "Quantidade de registros", name = "size", content = @Content(schema = @Schema(type = "integer", defaultValue = "5"))),
			@Parameter(in = ParameterIn.QUERY, description = "Ordenacao dos registros", name = "sort", content = @Content(array = @ArraySchema(schema = @Schema(type = "string")))) })

	@PostMapping
	public AutorOutput cria(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEntity = autorConvert.inputToNewEntity(autorInput);
		AutorEntity autorCriado = autorService.cria(autorEntity);
		return autorConvert.entityToOutput(autorCriado);
	}

	@PutMapping("/{id}")
	public AutorOutput atualiza(@PathVariable Long id, @RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		autorConvert.copyInputToEntity(autorEncontrado, autorInput);
		AutorEntity autorAtualizado = autorService.atualiza(autorEncontrado);
		return autorConvert.entityToOutput(autorAtualizado);
	}

	@GetMapping
	public Page<AutorOutput> listaTodos(
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) @Parameter(hidden = true) Pageable paginacao) {

		Page<AutorEntity> listaTodos = autorService.listaTodos(paginacao);
		return autorConvert.listPageEntityToListPageOutput(listaTodos);
	}

	@GetMapping("/{id}")
	public AutorOutput buscaPorId(@PathVariable Long id) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		return autorConvert.entityToOutput(autorEncontrado);
	}

	@GetMapping("/{id}/livros")
	public Page<LivroAutorOutput> buscaLivroPeloIdDoAutor(@PathVariable Long id,
			@PageableDefault(sort = "titulo", direction = Direction.ASC, page = 0, size = 10) @Parameter(hidden = true) Pageable paginacao) {
		autorService.buscaPeloId(id);
		Page<LivroEntity> livros = livroService.buscaLivrosPeloIdAutor(id, paginacao);
		return livroConvert.listPageEntityToListPageOutputCopy(livros);
	}

}