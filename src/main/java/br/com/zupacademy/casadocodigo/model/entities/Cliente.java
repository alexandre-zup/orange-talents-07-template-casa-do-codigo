package br.com.zupacademy.casadocodigo.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;


    @NotBlank
    @Column(nullable = false, unique = true)
    private String documento;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String documento, String nome, String sobrenome, String endereco, String complemento,
                   String cidade, String cep, String telefone, Pais pais, Estado estado) {
        this.email = email;
        this.documento = documento;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.pais = pais;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                '}';
    }
}
