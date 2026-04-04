package br.com.gabrielbcunha.controleestoquespringboot.service;

import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoRequest;
import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoResponse;
import br.com.gabrielbcunha.controleestoquespringboot.entity.Produto;
import br.com.gabrielbcunha.controleestoquespringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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

    public ProdutoResponse buscarProdutoPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O id do Produto deve existir e ser positivo");
        }

        Optional<Produto> produtoPorId = produtoRepository.findById(id);
        return produtoPorId.map(ProdutoResponse::new).orElse(null);
    }

    public ProdutoResponse modificarProduto(Long id, ProdutoRequest dadosNovosDoProduto) {
        Optional<Produto> produtoAlvo = produtoRepository.findById(id);

        String nome = dadosNovosDoProduto.getNome();
        BigDecimal preco = dadosNovosDoProduto.getPreco();
        int quantidade = dadosNovosDoProduto.getQuantidade();

        if (produtoAlvo.isPresent()) {
            Produto produto = produtoAlvo.get();

            if (dadosNovosDoProduto.getNome() == null  || dadosNovosDoProduto.getNome().isBlank()) {
                nome = produto.getNome();
            }
            if (dadosNovosDoProduto.getPreco() == null) {
                preco = produto.getPreco();
            }
            if (dadosNovosDoProduto.getQuantidade() < 0) {
                quantidade = produto.getQuantidade();
            }

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            Produto produtoSalvo = produtoRepository.save(produto);
            ProdutoResponse produtoResponse = new ProdutoResponse(produtoSalvo);
            return produtoResponse;
        }
        else {
            throw new IllegalArgumentException("O produto a ser modificado deve existir");
        }
    }

    public void removerProduto(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O id do Produto deve existir");
        }
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
        } else{
            throw new IllegalArgumentException("O produto a ser excluído deve existir");
        }
     }
}
