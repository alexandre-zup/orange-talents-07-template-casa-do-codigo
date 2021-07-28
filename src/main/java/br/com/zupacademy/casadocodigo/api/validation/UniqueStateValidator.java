package br.com.zupacademy.casadocodigo.api.validation;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoEstadoRequest;
import br.com.zupacademy.casadocodigo.model.entities.Estado;
import br.com.zupacademy.casadocodigo.model.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateValidator implements ConstraintValidator<UniqueState, NovoEstadoRequest> {
    @Autowired
    private EstadoRepository repository;

    @Override
    public boolean isValid(NovoEstadoRequest value, ConstraintValidatorContext context) {
        List<Estado> lista = repository.findByNomeAndPaisId(value.getNome(), value.getPaisId());

        Assert.state(lista.size() <= 1, "Existem 2 estados cadastrados para o mesmo pais. Estado: "
                + value.getNome() + ", paisId: " + value.getPaisId());

        return lista.isEmpty();
    }
}
