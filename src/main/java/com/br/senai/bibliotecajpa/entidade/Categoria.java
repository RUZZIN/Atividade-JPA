package com.br.senai.bibliotecajpa.entidade;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categoria")

public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livros;

    public Categoria() {
    }

    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
     public List<Livro> getLivros() {
        return livros;
     }
     public void setLivros(List<Livro> livros) {
        this.livros = livros;
     }
}
