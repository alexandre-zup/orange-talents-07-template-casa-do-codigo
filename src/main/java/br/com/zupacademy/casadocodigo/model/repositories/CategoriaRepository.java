package br.com.zupacademy.casadocodigo.model.repositories;

import br.com.zupacademy.casadocodigo.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNome(String nome);
}
