package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoAutorRequest;
import br.com.zupacademy.casadocodigo.api.validators.ProibeEmailAutorDuplicadoValidator;
import br.com.zupacademy.casadocodigo.model.entities.Autor;
import br.com.zupacademy.casadocodigo.model.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;
    @Autowired
    private ProibeEmailAutorDuplicadoValidator proibeEmailAutorDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailAutorDuplicadoValidator);
    }


    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        repository.save(autor);
    }
}
