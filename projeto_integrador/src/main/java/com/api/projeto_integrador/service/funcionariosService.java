package com.api.projeto_integrador.service;

import com.api.projeto_integrador.data.funcionariosEntity;
import com.api.projeto_integrador.data.funcionariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class funcionariosService {
    
    @Autowired
    
    funcionariosRepository funcionariosRepository;
    
    public funcionariosEntity criarFuncionario(funcionariosEntity func){
        
        func.setId(null);
        
        funcionariosRepository.save(func);
        
        return func;
        
    }
    
    public funcionariosEntity atualizarFuncionario(Integer funcId, funcionariosEntity funcionarioRequest){
        
        funcionariosEntity func = getFuncionarioId(funcId);
        
        func.setCargo(funcionarioRequest.getCargo());
        
        func.setCpf(funcionarioRequest.getCpf());
        
        func.setIdade(funcionarioRequest.getIdade());
        
        func.setNome(funcionarioRequest.getNome());
        
        func.setSalario(funcionarioRequest.getSalario());
        
        funcionariosRepository.save(func);
        
        return func;
        
    }
    
    public funcionariosEntity getFuncionarioId(Integer funcId){
        
        return funcionariosRepository.findById(funcId).orElse(null);
        
    }
    
    public List<funcionariosEntity> listarTodosFuncionarios(){
        
        return funcionariosRepository.findAll();
        
    }
    
    public void deletarFuncionario(Integer funcId){
        
        funcionariosEntity func = getFuncionarioId(funcId);
        
        funcionariosRepository.deleteById(func.getId());
        
    }
    
}
