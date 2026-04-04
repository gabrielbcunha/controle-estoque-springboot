package br.com.gabrielbcunha.controleestoquespringboot.controller;

import br.com.gabrielbcunha.controleestoquespringboot.dto.ProdutoRequest;
import br.com.gabrielbcunha.controleestoquespringboot.entity.Produto;
import br.com.gabrielbcunha.controleestoquespringboot.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto adiciionarProduto(@RequestBody ProdutoRequest request){
        return produtoService.adicionarProduto(request);
    }

}
