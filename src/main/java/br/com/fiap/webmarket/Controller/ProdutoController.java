package br.com.fiap.webmarket.Controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.webmarket.Repository.ProdutoRepository;
import br.com.fiap.webmarket.model.Produto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
@CacheConfig(cacheNames = "produtos")
public class ProdutoController {
    
    @Autowired
    ProdutoRepository repository;

    @GetMapping
    @Cacheable()
    public Page<Produto> index(
        @ParameterObject @PageableDefault (size = 5, sort = "data", direction = Direction.DESC) Pageable pageable,
        @RequestParam(required = false) String usuarioNome
    ){
        return repository.findByUsuarioNomeIgnoreCase(usuarioNome, pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict( allEntries  = true)
    public Produto create(@RequestBody @Valid Produto produto){
        return repository.save(produto);
    }
}
