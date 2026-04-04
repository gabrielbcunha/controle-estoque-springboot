package br.com.gabrielbcunha.controleestoquespringboot.controller;

import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoCreateRequest;
import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoPatchRequest;
import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoResponse;
import br.com.gabrielbcunha.controleestoquespringboot.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponse adicionarProduto(@Valid @RequestBody ProdutoCreateRequest request){
        return produtoService.adicionarProduto(request);
    }

    @GetMapping
    public List<ProdutoResponse> listarTodosProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoResponse listarProdutosPorId(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id);
    }

    @PatchMapping("/{id}")
    public ProdutoResponse modificarProdutoPorId(@PathVariable Long id, @RequestBody ProdutoPatchRequest request){
        return produtoService.modificarProduto(id, request);
    }

    @DeleteMapping("/{id}")
    public void removerProdutoPorId(@PathVariable Long id){
        produtoService.removerProduto(id);
    }
}
