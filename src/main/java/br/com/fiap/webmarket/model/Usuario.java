package br.com.fiap.webmarket.model;

import java.util.Random;

// record - objeto imutavel
public record Usuario(Long id, String email, String nome) {
    public Usuario(Long id, String email, String nome){
        var key = (id == null) ? Math.abs(new Random().nextLong()): id;
        this.id = key;
        this.email = email;
        this.nome = nome;
    }
}
