package br.com.gabrielbcunha.controleestoquespringboot.service;

import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoRequest;
import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoResponse;
import br.com.gabrielbcunha.controleestoquespringboot.entity.Produto;
import br.com.gabrielbcunha.controleestoquespringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto adicionarProduto(ProdutoRequest dadosDoProduto) {

        if (dadosDoProduto.getNome() == null || dadosDoProduto.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do Produto deve existir");
        }
        if (dadosDoProduto.getPreco() == null) {
            throw new IllegalArgumentException("O preço do Produto deve existir");
        }
        if (dadosDoProduto.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade do Produto deve ser positiva");
        }

        String nome = dadosDoProduto.getNome();
        BigDecimal preco = dadosDoProduto.getPreco();
        int quantidade = dadosDoProduto.getQuantidade();

        Produto novoProduto = new Produto(null, nome, preco, quantidade);
        Produto produtoSalvo = produtoRepository.save(novoProduto);
        return produtoSalvo;
    }

    public List<ProdutoResponse> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(ProdutoResponse::new)
                .collect(Collectors.toList());
        }
    }
