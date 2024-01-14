package com.api.projeto_integrador.service;

import com.api.projeto_integrador.data.produtoEntity;
import com.api.projeto_integrador.data.produtoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class produtoService {
    
    @Autowired
    
    produtoRepository produtoRepository;
    
    public produtoEntity criarProduto(produtoEntity produto){
        
        produto.setId(null);
        
        produtoRepository.save(produto);
        
        return produto;
        
    }
    
    public produtoEntity atualizarProduto(Integer produtoId, produtoEntity produtoRequest){
        
        produtoEntity produto = getProdutoId(produtoId);
        
        produto.setNome(produtoRequest.getNome());
        
        produto.setData(produtoRequest.getData());
        
        produto.setMarca(produtoRequest.getMarca());
        
        produto.setQuantidade(produtoRequest.getQuantidade());
        
        produto.setTipo(produtoRequest.getTipo());
        
        produto.setValor(produtoRequest.getValor());
        
        produtoRepository.save(produto);
        
        return produto;
        
    }
    
    public produtoEntity getProdutoId(Integer produtoId){
        
        return produtoRepository.findById(produtoId).orElse(null);
        
    }
    
    public List<produtoEntity> listarTodosProdutos(){
        
        return produtoRepository.findAll();
        
    }
    
    public void deletarProduto(Integer produtoId){
        
        produtoEntity produto = getProdutoId(produtoId);
        
        produtoRepository.deleteById(produto.getId());
        
    }
    
}
