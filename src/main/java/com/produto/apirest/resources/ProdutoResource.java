package com.produto.apirest.resources;

import com.produto.apirest.models.Produto;
import com.produto.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class ProdutoResource
{

    @Autowired
    ProdutoRepository _repositorioProduto;

    @ApiOperation(value="Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){

        return _repositorioProduto.findAll();
    }

    @ApiOperation(value="Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){

        return _repositorioProduto.findById(id);
    }

    @ApiOperation(value="Salva um produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto){

        return _repositorioProduto.save(produto);
    }

    @ApiOperation(value="Deleta um produto ")
    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto){

        _repositorioProduto.delete(produto);
    }

    @ApiOperation(value="Atualiza um produto")
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto){

        return _repositorioProduto.save(produto);
    }
}
