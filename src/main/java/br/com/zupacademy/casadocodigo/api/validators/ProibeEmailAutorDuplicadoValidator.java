package br.com.zupacademy.casadocodigo.api.validators;

import br.com.zupacademy.casadocodigo.api.dto.request.AutorRequest;
import br.com.zupacademy.casadocodigo.model.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailAutorDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorRequest request = (AutorRequest) target;

        if(autorRepository.existsByEmail(request.getEmail())) {
            errors.rejectValue("email", null,
                    "Já existe autor com o email informado: " + request.getEmail());
        }
    }
}
