package br.com.zupacademy.casadocodigo.model.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Length(max = 500)
    @Column(nullable = false, length = 500)
    private String resumo;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String sumario;

    @NotNull
    @Min(20)
    @Column(nullable = false)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    @Column(nullable = false)
    private Integer numeroDePaginas;

    @NotBlank
    @Column(nullable = false)
    private String isbn;

    @Future
    private Instant dataDaPublicacao;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Autor autor;

    public Livro(@NotBlank String titulo,
                 @NotBlank @Length(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer numeroDePaginas,
                 @NotBlank String isbn,
                 @Future Instant dataDaPublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDaPublicacao = dataDaPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", isbn='" + isbn + '\'' +
                ", dataDaPublicacao=" + dataDaPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
