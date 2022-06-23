package br.com.aceleragep.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.biblioteca.entities.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	List<LivroEntity> findAllByAutoresId(Long id);

}
