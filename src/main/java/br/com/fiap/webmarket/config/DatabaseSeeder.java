package br.com.fiap.webmarket.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.webmarket.Repository.ProdutoRepository;
import br.com.fiap.webmarket.Repository.UsuarioRepository;
import br.com.fiap.webmarket.model.Produto;
import br.com.fiap.webmarket.model.Usuario;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception{
        usuarioRepository.saveAll(
            List.of(
                Usuario.builder().id(1L).email("matheus@gmail.com").nome("Matheus").senha("abcd123").build(),
                Usuario.builder().id(2L).email("godoi@gmail.com").nome("Gustavo").senha("wxyz789").build()));

        produtoRepository.saveAll(
            List.of(
                Produto.builder()
                    .id(1L)
                    .nome("")
                    .marca("")
                    .modelo("")
                    .valor(45)
                    .quantidade(1)
                    .categoria("")
                    .descricao("")
                    .usuario(usuarioRepository.findById(1L).get())
                    .build(),

                Produto.builder()
                    .id(2L)
                    .nome("")
                    .marca("")
                    .modelo("")
                    .valor(50)
                    .quantidade(2)
                    .categoria("")
                    .descricao("")
                    .usuario(usuarioRepository.findById(2L).get())
                    .build()));
    }
}