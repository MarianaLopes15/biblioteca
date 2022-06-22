package br.com.aceleragep.biblioteca.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.aceleragep.biblioteca.dtos.outputs.LivroSemAutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.services.AutorService;
import br.com.aceleragep.biblioteca.services.LivroService;

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
	public List<AutorOutput> listaTodos() {
		List<AutorEntity> listaTodos = autorService.listaTodos();
		return autorConvert.entityToOutput(listaTodos);
	}

	@GetMapping("/{id}")
	public AutorOutput buscaPorId(@PathVariable Long id) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		return autorConvert.entityToOutput(autorEncontrado);
	}

	@GetMapping("/{id}/livros")
	public List<LivroSemAutorOutput> buscaLivroPeloIdDoAutor(@PathVariable Long id) {
		autorService.buscaPeloId(id);
		List<LivroEntity> livros = livroService.buscaLivrosPeloIdAutor(id);
		return livroConvert.entityToSemAutorOutput(livros);
	}

}