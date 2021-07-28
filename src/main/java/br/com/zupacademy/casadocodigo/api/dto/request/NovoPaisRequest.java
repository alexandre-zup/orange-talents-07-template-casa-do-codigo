package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.api.validation.UniqueValue;
import br.com.zupacademy.casadocodigo.model.entities.Pais;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "{validation.uniquevalue.pais.nome}")
    private String nome;

    public Pais toModel() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
