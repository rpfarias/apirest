package com.produtos.apirest.resources;


import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Classe que recebe as requisiçoes HTTP
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos") //Anotaçao do titulo da API
@CrossOrigin(origins = "*") //Libera qualquer dominio de acessar api
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/produto/{id}")
    @ApiOperation(value = "Retorna um produto unico")
    public Produto listaProdutoUnico(@PathVariable(value = "id")long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
