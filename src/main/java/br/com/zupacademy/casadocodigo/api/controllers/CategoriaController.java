package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovaCategoriaRequest;
import br.com.zupacademy.casadocodigo.api.validators.ProibeNomeCategoriaDuplicadoValidator;
import br.com.zupacademy.casadocodigo.model.entities.Categoria;
import br.com.zupacademy.casadocodigo.model.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProibeNomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria categoria = request.toModel();
        categoriaRepository.save(categoria);
    }
}
