package br.com.aceleragep.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.aceleragep.biblioteca.dtos.inputs.LivroInput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.exceptions.NotFoundBussinessException;
import br.com.aceleragep.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorService autorService;

	public LivroEntity cria(LivroEntity livroEntity, LivroInput livroInput) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getIdsAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
		return livroRepository.save(livroEntity);
	}

	public LivroEntity altera(LivroEntity livroEntity, LivroInput livroInput) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getIdsAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
		return livroRepository.save(livroEntity);
	}

	public void deleta(LivroEntity livroLocalizado) {
		livroRepository.delete(livroLocalizado);
	}

	public Page<LivroEntity> listaTodos(Pageable paginacao) {
		Page<LivroEntity> encontrou = livroRepository.findAll(paginacao);
		return encontrou;
	}

	public LivroEntity buscaLivroPeloId(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new NotFoundBussinessException(String.format("Livro %d não encontrado", id)));
	}

	public Page<LivroEntity> buscaLivrosPeloIdAutor(Long id, Pageable paginacao) {
		return livroRepository.findAllByAutoresId(id, paginacao);
	}

}
