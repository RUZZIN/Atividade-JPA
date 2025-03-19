package com.br.senai.bibliotecajpa.repository;

import com.br.senai.bibliotecajpa.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByAutor(String autor);

    List<Livro> findByCategoriaId(Integer categoriaId);

    List<Livro> findByQuantidadeDisponivel(Integer quantidadeDisponivel);


    @Query("SELECT lvr FROM Livro lvr where lvr.titulo like concat('%', :titulo, '%') ")
    List<Livro> findByTitulo(String titulo);

    @Query("SELECT lvr FROM Livro lvr where lvr.autor = :autor")
    List<Livro> findByAutorLivro(String autor);

}


