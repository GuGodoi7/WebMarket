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
                Usuario.builder().id(1L).email("matheus@gmail.com").nome("Matheus").build(),
                Usuario.builder().id(2L).email("godoi@gmail.com").nome("Gustavo").build(),
                Usuario.builder().id(3L).email("caio@gmail.com").nome("Caio").build(),
                Usuario.builder().id(4L).email("lucas@gmail.com").nome("Lucas").build(),
                Usuario.builder().id(5L).email("guilherme@gmail.com").nome("Guilherme").build()));

        produtoRepository.saveAll(
            List.of(
                Produto.builder()
                    .id(1L)
                    .nome("rtx 1080ti")
                    .marca("nvidia")
                    .modelo("1080ti")
                    .valor(4500)
                    .quantidade(1)
                    .categoria("ELETRONICO")
                    .descricao("placa de video")
                    .usuario(usuarioRepository.findById(1L).get())
                    .build(),

                Produto.builder()
                    .id(2L)
                    .nome("camiseta supreme michael jordan")
                    .marca("supreme")
                    .modelo("M")
                    .valor(500)
                    .quantidade(2)
                    .categoria("VESTIMENTA")
                    .descricao("camisa do hype")
                    .usuario(usuarioRepository.findById(2L).get())
                    .build(),
                    
                Produto.builder()
                    .id(3L)
                    .nome("Smart TV 4K")
                    .marca("Sony")
                    .modelo("Bravia XR")
                    .valor(3499)
                    .quantidade(1)
                    .categoria("ELETRONICO")
                    .descricao("TV com resolução 4K e tecnologia HDR")
                    .usuario(usuarioRepository.findById(1L).get())
                    .build(),

                Produto.builder()
                    .id(4L)
                    .nome("Fone de Ouvido Bluetooth")
                    .marca("Bose")
                    .modelo("QuietComfort 45")
                    .valor(499)
                    .quantidade(10)
                    .categoria("ELETRONICO")
                    .descricao("fones de ouvido com cancelamento de ruído")
                    .usuario(usuarioRepository.findById(3L).get())
                    .build(),

                Produto.builder()
                    .id(5L)
                    .nome("Vestido Floral")
                    .marca("Zara")
                    .modelo("Primavera/Verão 2024")
                    .valor(129)
                    .quantidade(3)
                    .categoria("VESTIMENTA")
                    .descricao("vestido leve e elegante com estampa floral")
                    .usuario(usuarioRepository.findById(2L).get())
                    .build(),

                Produto.builder()
                    .id(6L)
                    .nome("Tênis Esportivo")
                    .marca("Nike")
                    .modelo("Air Zoom Pegasus 38")
                    .valor(249)
                    .quantidade(5)
                    .categoria("VESTIMENTA")
                    .descricao("tênis de corrida com amortecimento responsivo")
                    .usuario(usuarioRepository.findById(4L).get())
                    .build()));
    }
}