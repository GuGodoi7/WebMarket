package br.com.fiap.webmarket.Controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Produto> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict( allEntries  = true)
    public Produto create(@RequestBody @Valid Produto produto){
        return repository.save(produto);
    }
}
