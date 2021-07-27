package br.com.zupacademy.casadocodigo.api.dto.request;

import br.com.zupacademy.casadocodigo.api.validation.ExistsId;
import br.com.zupacademy.casadocodigo.api.validation.UniqueValue;
import br.com.zupacademy.casadocodigo.model.entities.Autor;
import br.com.zupacademy.casadocodigo.model.entities.Categoria;
import br.com.zupacademy.casadocodigo.model.entities.Livro;
import br.com.zupacademy.casadocodigo.model.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.model.repositories.CategoriaRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;


public class NovoLivroRequest {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "{validation.uniquevalue.livro.titulo}")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "{validation.uniquevalue.livro.isbn}")
    private String isbn;

    @Future
    private Instant dataDaPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id", message = "{validation.existsId.livro.categoriaId}")
    private Long categoriaId;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id", message = "{validation.existsId.livro.autorId}")
    private Long autorId;

    public NovoLivroRequest(String titulo,
                            @NotBlank @Length(max = 500) String resumo,
                            String sumario,
                            @NotNull @Min(20) BigDecimal preco,
                            @NotNull @Min(100) Integer numeroDePaginas,
                            @NotBlank String isbn,
                            @Nullable @Future Instant dataDaPublicacao,
                            @NotNull Long categoriaId,
                            @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDaPublicacao = dataDaPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    /**
     * Converte um NovoLivroRequest para o tipo Livro
     * @return returna {@code Livro} se os dados forem válidos, caso contrário, retorna {@code null}
     */
    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> optionalAutor = autorRepository.findById(autorId);
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoriaId);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn,
                this.dataDaPublicacao, optionalCategoria.get(), optionalAutor.get());
    }
}
