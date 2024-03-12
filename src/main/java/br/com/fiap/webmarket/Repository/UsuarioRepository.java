package br.com.fiap.webmarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.webmarket.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

}
    

