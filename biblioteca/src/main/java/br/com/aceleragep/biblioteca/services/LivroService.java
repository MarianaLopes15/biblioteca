package br.com.aceleragep.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.exceptions.NotFoundBussinessException;
import br.com.aceleragep.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public LivroEntity cria(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}

	public LivroEntity altera(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}

	public void deleta(LivroEntity livroLocalizado) {
		livroRepository.delete(livroLocalizado);
	}

	public List<LivroEntity> listaTodos() {
		return livroRepository.findAll();
	}

	public LivroEntity buscaLivroPeloId(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new NotFoundBussinessException(String.format("Livro %d não encontrado", id)));
	}

}
