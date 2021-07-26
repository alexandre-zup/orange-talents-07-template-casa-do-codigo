package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.model.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
    @NotBlank
    private String nome;

    @Deprecated
    public NovaCategoriaRequest() {
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }
}
