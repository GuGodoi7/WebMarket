package br.com.fiap.webmarket.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.webmarket.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
        Page<Produto>findByUsuarioNomeIgnoreCase(String usuarioNome, Pageable pageable);
}
