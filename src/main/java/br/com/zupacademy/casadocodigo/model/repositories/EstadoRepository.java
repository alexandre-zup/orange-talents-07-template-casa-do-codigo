package br.com.zupacademy.casadocodigo.model.repositories;

import br.com.zupacademy.casadocodigo.model.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNomeAndPaisId(String nome, Long paisId);

    boolean existsByPaisId(Long paisId);
}
