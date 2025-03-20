package com.br.senai.bibliotecajpa.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "O autor é obrigatório.")
    @Size(max = 100, message = "O autor deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String autor;

    @NotNull(message = "O ano de publicação é obrigatório.")
    @Column(name = "ano_publicacao", nullable = false)
    private Integer anoPublicacao;

    @NotNull(message = "A quantidade disponível é obrigatória.")
    @Column(name = "quantidade_disponivel", nullable = false)
    private Integer quantidadeDisponivel;

    @PastOrPresent(message = "A data de cadastro não pode estar no futuro.")
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @NotBlank(message = "O ISBN é obrigatório.")
    @Size(max = 13, message = "O ISBN deve ter no máximo 13 caracteres.")
    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @NotBlank(message = "A editora é obrigatória.")
    @Size(max = 255, message = "A editora deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String editora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, Integer anoPublicacao, Integer quantidadeDisponivel, LocalDate dataCadastro, String isbn, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataCadastro = dataCadastro;
        this.isbn = isbn;
        this.editora = editora;
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
        return Objects.equals(id, livro.id) &&
               Objects.equals(titulo, livro.titulo) &&
               Objects.equals(autor, livro.autor) &&
               Objects.equals(anoPublicacao, livro.anoPublicacao) &&
               Objects.equals(quantidadeDisponivel, livro.quantidadeDisponivel) &&
               Objects.equals(dataCadastro, livro.dataCadastro) &&
               Objects.equals(isbn, livro.isbn) &&
               Objects.equals(editora, livro.editora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, anoPublicacao, quantidadeDisponivel, dataCadastro, isbn, editora);
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
                ", isbn='" + isbn + '\'' +
                ", editora='" + editora + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}