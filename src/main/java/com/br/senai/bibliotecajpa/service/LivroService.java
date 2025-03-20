package com.br.senai.bibliotecajpa.service;

import com.br.senai.bibliotecajpa.entidade.Livro;
import com.br.senai.bibliotecajpa.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @Transactional
    public Livro save(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("O título do livro é obrigatório.");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new IllegalArgumentException("O autor do livro é obrigatório.");
        }
        if (livro.getIsbn() == null || livro.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("O ISBN do livro é obrigatório.");
        }
        return livroRepository.save(livro);
    }

    @Transactional
    public void delete(Integer id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado para exclusão");
        }
        livroRepository.deleteById(id);
    }

    @Transactional
    public Livro update(Livro livro) {
        if (livro.getId() == null || !livroRepository.existsById(livro.getId())) {
            throw new RuntimeException("Livro não encontrado para atualização");
        }
        return save(livro);
    }
}