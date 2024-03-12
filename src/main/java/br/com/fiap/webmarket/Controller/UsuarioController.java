package br.com.fiap.webmarket.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webmarket.Repository.UsuarioRepository;
import br.com.fiap.webmarket.model.Usuario;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("usuario")
@Slf4j
public class UsuarioController {
    
    
    @Autowired //Injeção de Dependência
    UsuarioRepository repository;
    
    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        log.info("cadastrando usuario {}", usuario);
        return usuario; 
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando usuario {}", id);

        var usuarioEncontrado = repository.findById(id);
        
        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        
        repository.delete(usuarioEncontrado.get());
        return ResponseEntity.noContent().build();
}

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(
        @PathVariable Long id,
        @RequestBody Usuario usuario
        ){
        log.info("atualizando usuario {} para {}", id, usuario);

        var usuarioEncontrado = repository.findById(id);
              
        if(usuarioEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        var usuarioNovo = new Usuario(id, null, null);
        usuarioNovo.setId(id);
        usuarioNovo.setNome(usuario.getNome());
        usuarioNovo.setEmail(usuario.getEmail());

        repository.save(usuarioNovo);

        return ResponseEntity.ok(usuarioNovo);
     }
}
