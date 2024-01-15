package com.api.projeto_integrador.controller;

import com.api.projeto_integrador.data.movimentaçãoEntity;
import com.api.projeto_integrador.service.movimentaçãoService;
import java.util.List;
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
@RequestMapping("/movimentação")

public class movimentaçãoController {
    
    @Autowired
    
    movimentaçãoService movimentaçãoService;
    
    @GetMapping("/listar")
    
    public ResponseEntity<List> getAllMovimentações(){
        
        List<movimentaçãoEntity> movimentações = movimentaçãoService.listarTodasMovimentações();
        
        return new ResponseEntity<>(movimentações, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    
    public ResponseEntity<movimentaçãoEntity> getMovimentaçãoById(@PathVariable Integer id){
        
        movimentaçãoEntity movimentação = movimentaçãoService.getMovimentaçãoId(id);
        
        return new ResponseEntity<>(movimentação, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    
    public ResponseEntity<movimentaçãoEntity> addMovimentação(@RequestBody movimentaçãoEntity mov){
        
        var novaMovimentação = movimentaçãoService.criarMovimentação(mov);
        
        return new ResponseEntity<>(novaMovimentação, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualziar")
    
    public ResponseEntity<movimentaçãoEntity> atualizarMovimentação(@PathVariable Integer id,@RequestBody movimentaçãoEntity mov){
        
        var movimentaçãoAtualizada = movimentaçãoService.atualizarMovimentação(id, mov);
        
        return new ResponseEntity<>(movimentaçãoAtualizada, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    
    public ResponseEntity deletarMovimentação(@PathVariable Integer id){
        
        movimentaçãoService.deletarMovimentação(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
