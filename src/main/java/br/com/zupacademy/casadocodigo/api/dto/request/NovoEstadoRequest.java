package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.api.validation.ExistsId;
import br.com.zupacademy.casadocodigo.api.validation.UniqueState;
import br.com.zupacademy.casadocodigo.model.entities.Estado;
import br.com.zupacademy.casadocodigo.model.entities.Pais;
import br.com.zupacademy.casadocodigo.model.repositories.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueState
public class NovoEstadoRequest {
    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Pais.class, message = "{validation.existsId.estado.paisId}")
    private Long paisId;

    public NovoEstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(paisId).get();
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
