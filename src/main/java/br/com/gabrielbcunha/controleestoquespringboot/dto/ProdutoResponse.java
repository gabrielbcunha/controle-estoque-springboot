package br.com.gabrielbcunha.controleestoquespringboot.dto;

import br.com.gabrielbcunha.controleestoquespringboot.entity.Produto;
import lombok.Data;

import java.math.BigDecimal;
@Data
 public class ProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }
}
