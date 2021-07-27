package br.com.zupacademy.casadocodigo.api.dto.response;

import br.com.zupacademy.casadocodigo.model.entities.Livro;

public class LivroResponse {
    private Long id;
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
