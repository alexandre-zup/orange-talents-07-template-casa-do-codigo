package br.com.zupacademy.casadocodigo.api.validation;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoClienteRequest;
import br.com.zupacademy.casadocodigo.model.entities.Estado;
import br.com.zupacademy.casadocodigo.model.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class StateAndCountryValidator implements ConstraintValidator<StateAndCountry, NovoClienteRequest> {
    @Autowired
    private EstadoRepository estadoRepository;

    private StateAndCountry existsStateAnnotation;

    @Override
    public void initialize(StateAndCountry constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NovoClienteRequest request, ConstraintValidatorContext context) {
        boolean countryHaveState = estadoRepository.existsByPaisId(request.getPaisId());

        /*
        se pais não possuir estado ->
            return true/valido se o EstadoId da request for nulo
            return false/invalido se o EstadoId da request tiver dados
         */
        if(!countryHaveState)
            return request.getEstadoId() == null;

        /*
        a aplicação só irá executar daqui pra baixo, se o país tiver estados
        se país possuir estado, então é obrigatório informar o estadoId
            return false/invalido se estiver null
         */
        if(request.getEstadoId() == null)
            return false;

        Optional<Estado> optionalEstado = estadoRepository.findById(request.getEstadoId());

        /*
        se estado existir ->
            return true/valido se o Estado pertencer a outro país
            return false/invalido se Estado pertencer a outro país
         */
        if(optionalEstado.isPresent()) {
            Estado estado = optionalEstado.get();
            Long paisId = estado.getIdDoPais();

            return paisId == request.getPaisId();
        }

        /*
        se estado não existir, retorna false/invalido
         */
        return false;
    }
}
