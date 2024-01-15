package com.api.projeto_integrador.service;

import com.api.projeto_integrador.data.movimentaçãoEntity;
import com.api.projeto_integrador.data.movimentaçãoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class movimentaçãoService {
    
    @Autowired
    
    movimentaçãoRepository movimentaçãoRepository;
    
    public movimentaçãoEntity criarMovimentação(movimentaçãoEntity mov){
        
        mov.setId(null);
        
        movimentaçãoRepository.save(mov);
        
        return mov;
        
    }
    
    public movimentaçãoEntity atualizarMovimentação(Integer movId, movimentaçãoEntity movimentaçãoRequest){
        
        movimentaçãoEntity mov = getMovimentaçãoId(movId);
        
        mov.setData(movimentaçãoRequest.getData());
        
        mov.setDescr(movimentaçãoRequest.getDescr());
        
        mov.setEntrada(movimentaçãoRequest.isEntrada());
        
        mov.setValor(movimentaçãoRequest.getValor());
        
        movimentaçãoRepository.save(mov);
        
        return mov;
        
    }
    
    public movimentaçãoEntity getMovimentaçãoId(Integer movId){
        
        return movimentaçãoRepository.findById(movId).orElse(null);
        
    }
    
    public List<movimentaçãoEntity> listarTodasMovimentações(){
        
        return movimentaçãoRepository.findAll();
        
    }
    
    public void deletarMovimentação(Integer movId){
        
        movimentaçãoEntity mov = getMovimentaçãoId(movId);
        
        movimentaçãoRepository.deleteById(mov.getId());
        
    }
    
}
