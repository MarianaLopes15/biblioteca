package br.com.aceleragep.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public AutorEntity cria(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}

	public AutorEntity atualiza(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}

	public List<AutorEntity> listaTodos() {
		return autorRepository.findAll();
	}
	
	public AutorEntity buscaPeloId(Long id) {
		Optional<AutorEntity> encontrou = autorRepository.findById(id);
		if (encontrou.isPresent()) {
			return encontrou.get();
		} else {
			throw new RuntimeException("Autor " + id + " não encontrado");
		}
	}

}
