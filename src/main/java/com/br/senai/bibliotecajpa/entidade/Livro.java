package com.br.senai.bibliotecajpa.entidade;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column
    private Integer anoPublicacao;

    @Column
    private Integer quantidadeDisponivel;

    @Column
    private LocalDate dataCadastro;

    @Column
    private String isbn;

    @Column
    private String editora;

    @ManyToOne
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, Integer anoPublicacao, Integer quantidadeDisponivel, LocalDate dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor) && Objects.equals(anoPublicacao, livro.anoPublicacao) && Objects.equals(quantidadeDisponivel, livro.quantidadeDisponivel) && Objects.equals(dataCadastro, livro.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, anoPublicacao, quantidadeDisponivel, dataCadastro);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
