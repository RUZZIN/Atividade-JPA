package com.br.senai.bibliotecajpa.service;

import com.br.senai.bibliotecajpa.entidade.Categoria;
import com.br.senai.bibliotecajpa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Categoria findById(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public void delete(int id) {
        categoriaRepository.deleteById(id);
    }
    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
