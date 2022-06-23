package br.com.aceleragep.biblioteca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_livros")
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titulo", length = 200)
	private String titulo;

	@Column(name = "ano_lancamento")
	private Integer anoLancamento;

	@JoinColumn(name = "autor_id")
	@ManyToMany
	private List<AutorEntity> autores;
}
