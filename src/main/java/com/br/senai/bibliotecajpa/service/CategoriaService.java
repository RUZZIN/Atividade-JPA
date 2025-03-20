package com.br.senai.bibliotecajpa.service;

import com.br.senai.bibliotecajpa.entidade.Categoria;
import com.br.senai.bibliotecajpa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria saveCategoria(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria é obrigatório.");
        }
        return categoriaRepository.save(categoria);
    }

    public Categoria findById(int id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public void delete(int id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada para exclusão");
        }
        categoriaRepository.deleteById(id);
    }

    @Transactional
    public Categoria update(Categoria categoria) {
        if (categoria.getId() == null || !categoriaRepository.existsById(categoria.getId())) {
            throw new RuntimeException("Categoria não encontrada para atualização");
        }
        return categoriaRepository.save(categoria);
    }
}