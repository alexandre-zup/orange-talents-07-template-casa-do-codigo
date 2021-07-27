package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.request.NovoLivroRequest;
import br.com.zupacademy.casadocodigo.api.dto.response.LivroResponse;
import br.com.zupacademy.casadocodigo.model.entities.Livro;
import br.com.zupacademy.casadocodigo.model.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.model.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = request.toModel(autorRepository, categoriaRepository);
        livroRepository.save(livro);
    }

    @GetMapping
    public List<LivroResponse> lista() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }
}
