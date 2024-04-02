package br.com.fiap.webmarket.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.fiap.webmarket.Repository.UsuarioRepository;
import br.com.fiap.webmarket.model.Usuario;
import jakarta.validation.Valid;
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
    @ResponseStatus(CREATED)
    public Usuario create(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario {}", usuario);
        
        return repository.save(usuario); 
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando usuario {}", id);
        verificarSeUsuarioExiste(id);
        repository.deleteById(id);
}

    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("atualizando usuario {} para {}", id, usuario);
        verificarSeUsuarioExiste(id);
        usuario.setId(id);
        return repository.save(usuario);
     }

     
     private void verificarSeUsuarioExiste(Long id){
        repository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(
                            NOT_FOUND,
                            "Erro ao deletar. Verifique o id informado")
            );
     }
}
