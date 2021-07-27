package br.com.zupacademy.casadocodigo.model.repositories;

import br.com.zupacademy.casadocodigo.model.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
