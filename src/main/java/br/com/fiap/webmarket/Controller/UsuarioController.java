package br.com.fiap.webmarket.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webmarket.model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Usuario> repository = new ArrayList<>();
    
    private Optional<Usuario> getUsuarioById(Long id) {
        var usuarioEncontrado = repository
                        .stream()
                        .filter(u -> u.id().equals(id))
                        .findFirst();
        return usuarioEncontrado;
    }
    @GetMapping
    public List<Usuario> index() {
        return repository;
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        log.info("cadastrando usuario {}", usuario);
        repository.add(usuario);
        return usuario; 
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando usuario {}", id);

        var usuarioEncontrado = getUsuarioById(id);
        
        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        
        repository.remove(usuarioEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(
        @PathVariable Long id,
        @RequestBody Usuario usuario
    ){
        log.info("atualizando usuario {} para {}", id, usuario);

        var usuarioEncontrado = getUsuarioById(id);
        
        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        var usuarioAntigo = usuarioEncontrado.get();

        var usuarioNovo = new Usuario(id, usuario.email(), usuario.nome());

        repository.remove(usuarioAntigo);
        repository.add(usuarioNovo);

        return ResponseEntity.ok(usuarioNovo);
    }
}
