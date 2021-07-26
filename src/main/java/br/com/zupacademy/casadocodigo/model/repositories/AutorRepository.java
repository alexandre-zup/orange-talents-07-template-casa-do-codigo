package br.com.zupacademy.casadocodigo.model.repositories;

import br.com.zupacademy.casadocodigo.model.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsByEmail(String email);
}
