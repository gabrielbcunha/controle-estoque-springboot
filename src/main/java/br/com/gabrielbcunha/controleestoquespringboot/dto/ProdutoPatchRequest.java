package br.com.gabrielbcunha.controleestoquespringboot.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoPatchRequest {

    private String nome;

    private BigDecimal preco;

    private int quantidade;
}
