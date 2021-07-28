package br.com.zupacademy.casadocodigo.api.dto.response;

import br.com.zupacademy.casadocodigo.model.entities.Autor;
import br.com.zupacademy.casadocodigo.model.entities.Livro;

public class DetalheLivroResponse {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private String isbn;
    private Integer numeroDePaginas;
    private AutorResponse autor;

    public DetalheLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsbn();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.autor = new AutorResponse(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public AutorResponse getAutor() {
        return autor;
    }

    public class AutorResponse {
        private Long id;
        private String nome;
        private String descricao;

        public AutorResponse(Autor autor) {
            this.id = autor.getId();
            this.nome = autor.getNome();
            this.descricao = autor.getDescricao();
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
