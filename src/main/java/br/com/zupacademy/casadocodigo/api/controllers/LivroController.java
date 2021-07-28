package br.com.zupacademy.casadocodigo.api.controllers;

import br.com.zupacademy.casadocodigo.api.dto.response.DetalheLivroResponse;
import br.com.zupacademy.casadocodigo.api.dto.response.LivroResponse;
import br.com.zupacademy.casadocodigo.model.entities.Livro;
import br.com.zupacademy.casadocodigo.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroResponse> lista() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroResponse> detalha(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);

        if(livro == null) {
            return ResponseEntity.notFound().build();
        }

        DetalheLivroResponse response = new DetalheLivroResponse(livro);
        return ResponseEntity.ok().body(response);
    }
}
