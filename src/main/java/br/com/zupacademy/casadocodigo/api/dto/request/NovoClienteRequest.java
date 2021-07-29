package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.api.validation.BrazilianDocument;
import br.com.zupacademy.casadocodigo.api.validation.ExistsId;
import br.com.zupacademy.casadocodigo.api.validation.StateAndCountry;
import br.com.zupacademy.casadocodigo.api.validation.UniqueValue;
import br.com.zupacademy.casadocodigo.model.entities.Cliente;
import br.com.zupacademy.casadocodigo.model.entities.Estado;
import br.com.zupacademy.casadocodigo.model.entities.Pais;
import br.com.zupacademy.casadocodigo.model.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.model.repositories.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@StateAndCountry
public class NovoClienteRequest {
    @Email
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = Cliente.class, message = "{validation.uniquevalue.cliente.email}")
    private String email;

    @NotBlank
    @BrazilianDocument
    @UniqueValue(fieldName = "documento", domainClass = Cliente.class,
            message = "{validation.uniquevalue.cliente.documento}")
    private String documento;

    @NotBlank private String nome;
    @NotBlank private String sobrenome;
    @NotBlank private String endereco;
    @NotBlank private String complemento;
    @NotBlank private String cidade;
    @NotBlank private String cep;
    @NotBlank private String telefone;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Pais.class)
    private Long paisId;

    private Long estadoId;

    public NovoClienteRequest(String email, String documento, String nome, String sobrenome, String endereco,
                              String complemento, String cidade, String cep, String telefone, Long paisId,
                              Long estadoId) {
        this.email = email;
        this.documento = documento;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.paisId = paisId;
        this.estadoId = estadoId;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        @NotNull Pais pais = paisRepository.findById(paisId).get();
        Estado estado;

        if(estadoId == null) {
            estado = null;
        }
        else {
            estado = estadoRepository.findById(estadoId).get();
        }


        return new Cliente(this.email, this.documento, this.nome, this.sobrenome, this.endereco, this.complemento,
                this.cidade, this.cep, this.telefone, pais, estado);
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}
