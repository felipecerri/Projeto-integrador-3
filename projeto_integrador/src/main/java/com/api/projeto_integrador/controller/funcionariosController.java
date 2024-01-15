package com.api.projeto_integrador.controller;

import com.api.projeto_integrador.data.funcionariosEntity;
import com.api.projeto_integrador.service.funcionariosService;
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
@RequestMapping("/funcionario")

public class funcionariosController {
    
    @Autowired
    
    funcionariosService funcionariosService;
    
    @GetMapping("/listar")
    
    public ResponseEntity<List> getAllFuncionarios(){
        
        List<funcionariosEntity> funcionarios = funcionariosService.listarTodosFuncionarios();
        
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    
    public ResponseEntity<funcionariosEntity> getFuncionarioById(@PathVariable Integer id){
        
        funcionariosEntity funcionario = funcionariosService.getFuncionarioId(id);
        
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    
    public ResponseEntity<funcionariosEntity> addFuncionario(@RequestBody funcionariosEntity func){
        
        var novoFuncionario = funcionariosService.criarFuncionario(func);
        
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualizar/{id}")
    
    public ResponseEntity<funcionariosEntity> atualizarFuncionario(@PathVariable Integer id, @RequestBody funcionariosEntity func){
        
        var funcionarioAtualizado = funcionariosService.atualizarFuncionario(id, func);
        
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    
    public ResponseEntity deletarFuncionario(@PathVariable Integer id){
        
        funcionariosService.deletarFuncionario(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
