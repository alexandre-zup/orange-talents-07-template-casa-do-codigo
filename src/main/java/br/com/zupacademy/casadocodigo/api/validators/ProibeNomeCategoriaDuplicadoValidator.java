package br.com.zupacademy.casadocodigo.api.validators;

import br.com.zupacademy.casadocodigo.api.dto.request.NovaCategoriaRequest;
import br.com.zupacademy.casadocodigo.model.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCategoriaRequest request = (NovaCategoriaRequest) target;

        if(categoriaRepository.existsByNome(request.getNome())) {
            errors.rejectValue("nome", null,
                    "Já existe uma categoria com o nome informado: " + request.getNome());
        }
    }
}
