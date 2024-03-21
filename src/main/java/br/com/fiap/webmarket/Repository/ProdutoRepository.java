package br.com.fiap.webmarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.webmarket.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
        
}
