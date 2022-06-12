package com.produto.apirest.repository;

import com.produto.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id);
}
