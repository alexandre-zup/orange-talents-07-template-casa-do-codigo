package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.model.entities.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    @Length(max = 255)
    private String nome;

    @NotBlank
    @Length(max = 255)
    @Email
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    /**
     *
     * @param nome  máximo 255 caracteres
     * @param email email com formato válido e máximo 255 caracteres
     * @param descricao máximo 400 caracteres
     */
    public AutorRequest(@NotBlank @Length(max = 255) String nome,
                        @NotBlank @Length(max = 255) @Email String email,
                        @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
