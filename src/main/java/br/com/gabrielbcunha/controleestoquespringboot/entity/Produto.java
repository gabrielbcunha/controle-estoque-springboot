package br.com.gabrielbcunha.controleestoquespringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private Long id;

    @Column(name = "nome_prod", nullable = false, length = 150)
    private String nome;

    @Column(name = "preco_prod", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "quant_prod", nullable = false)
    private int quantidade;
}
