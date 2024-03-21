package br.com.fiap.webmarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double valor;
    private int quantidade;
    private String categoria;
    private String descricao;
}
