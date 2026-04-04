package br.com.gabrielbcunha.controleestoquespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoCreateRequest {

    @NotBlank(message = "O nome do Produto deve existir")
    private String nome;

    @NotNull(message = "O preço do produto não pode ser nulo")
    @PositiveOrZero(message = "O preço do produto deve ser positivo ou zero")
    private BigDecimal preco;

    @PositiveOrZero(message = "A quantidade do Produto deve ser positiva ou zero")
    private int quantidade;
}
