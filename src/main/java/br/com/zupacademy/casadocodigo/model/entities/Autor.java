package br.com.zupacademy.casadocodigo.model.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Instant instanteDoRegistro;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;


    @NotBlank
    @Length(max = 400)
    @Column(nullable = false, length = 400)
    private String descricao;

    /**
     * @deprecated
     */
    @Deprecated
    public Autor() {
    }

    /**
     * @param nome      máximo 255 caracteres
     * @param email     email com formato válido e máximo 255 caracteres
     * @param descricao máximo 400 caracteres
     */
    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instanteDoRegistro = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public Instant getInstanteDoRegistro() {
        return instanteDoRegistro;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", instanteDoRegistro=" + instanteDoRegistro +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
