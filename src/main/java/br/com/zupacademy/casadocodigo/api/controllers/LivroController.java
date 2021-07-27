package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoLivroRequest;
import br.com.zupacademy.casadocodigo.model.entities.Livro;
import br.com.zupacademy.casadocodigo.model.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.model.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = request.toModel(autorRepository, categoriaRepository);
        repository.save(livro);
    }
}
