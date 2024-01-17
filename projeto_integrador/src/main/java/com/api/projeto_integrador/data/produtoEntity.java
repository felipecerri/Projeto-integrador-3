package com.api.projeto_integrador.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="produto")
public class produtoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Size(min=2, message="Digite um nome com no minimo 2 caracteres")
    private String nome;
    @Size(min=2, message="Digite um nome com no tipo 2 caracteres")
    private String tipo;
    
    @Size(min=2, message="Digite um nome com no marca 2 caracteres")
    private String marca;
    
    @Min(0)
    private double valor;
    
    private String data;
    
    @Min(0)
    private Integer quantidade;
    
    
}
