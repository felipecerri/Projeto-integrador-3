package com.api.projeto_integrador.controller;

import com.api.projeto_integrador.data.produtoEntity;
import com.api.projeto_integrador.service.produtoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/produto")

public class produtoController {
    
    @Autowired
    
    produtoService produtoService;
    
    @GetMapping("/listar")
    
    public ResponseEntity<List> getAllProdutos(){
        
        List<produtoEntity> produtos = produtoService.listarTodosProdutos();
        
        return new ResponseEntity<>(produtos, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    
    public ResponseEntity<produtoEntity> getProdutoById(@PathVariable Integer id){
        
        produtoEntity produto = produtoService.getProdutoId(id);
        
        return new ResponseEntity<>(produto, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    
    public ResponseEntity<produtoEntity> addProduto(@RequestBody produtoEntity produto){
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d", Locale.ENGLISH);
        
        LocalDate dateTime = LocalDate.parse(produto.getData(),formatter);
        
        if(dateTime.isBefore(LocalDate.now())){
            
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT );
            
        }else{
        
        var novoProduto = produtoService.criarProduto(produto);
        
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        
        }
    }
    
    @PutMapping("/atualizar/{id}")
    
    public ResponseEntity<produtoEntity> atualizarProduto(@PathVariable Integer id, @RequestBody produtoEntity produto){
        
        var produtoAtualizado = produtoService.atualizarProduto(id, produto);
        
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    
    public ResponseEntity deletarProduto(@PathVariable Integer id){
        
        produtoService.deletarProduto(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
