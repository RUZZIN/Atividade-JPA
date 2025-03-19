package com.br.senai.bibliotecajpa.repository;


import com.br.senai.bibliotecajpa.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
