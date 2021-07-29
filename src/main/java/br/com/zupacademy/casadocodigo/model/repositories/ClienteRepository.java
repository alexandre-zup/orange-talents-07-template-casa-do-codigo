package br.com.zupacademy.casadocodigo.model.repositories;

import br.com.zupacademy.casadocodigo.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
