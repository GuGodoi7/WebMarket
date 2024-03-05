package br.com.fiap.webmarket.model;

import java.util.Random;

// record - objeto imutavel
public record Usuario(Long id, String email, String nome) {
    public Usuario(Long id, String email, String nome){
        this.id = Math.abs(new Random().nextLong());
        this.email = email;
        this.nome = nome;
    }
}
