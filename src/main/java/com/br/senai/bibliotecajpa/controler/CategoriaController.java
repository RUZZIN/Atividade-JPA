package com.br.senai.bibliotecajpa.controler;

import com.br.senai.bibliotecajpa.entidade.Categoria;
import com.br.senai.bibliotecajpa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }
    @GetMapping("/{id}")
    public Categoria findById(@PathVariable int id){
        return categoriaService.findById(id);
    }
    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.saveCategoria(categoria);
    }
    @PutMapping
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaService.update( categoria );
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoriaService.delete(id);
    }
}
