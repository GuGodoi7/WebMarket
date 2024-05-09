package br.com.fiap.webmarket.model;

import br.com.fiap.webmarket.validation.TipoCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 255, message="{produto.nome.size}")
    private String nome;

    @Size(max = 255, message="{produto.marca.size}")
    private String marca;

    @Size(max = 255, message="{produto.modelo.size}")
    private String modelo;

    @Positive(message="{produto.valor.positive}")
    private double valor;

    @PositiveOrZero(message="{produto.quantidade.positiveorzero}")
    private int quantidade;

    @Size(max = 255, message="{produto.categoria.size}")
    @TipoCategoria
    private String categoria;

    @Size(max = 255, message="{produto.descricao.size}")
    private String descricao;

    @ManyToOne
    private Usuario usuario;
}
