package com.api.projeto_integrador.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="produto")
public class produtoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Nome obrigatorio")
    @Size(min=2, message="Digite um nome com no minimo 2 caracteres")
    private String nome;
    
    @NotBlank(message="Tipo obrigatorio")
    @Size(min=2, message="Digite um nome com no tipo 2 caracteres")
    private String tipo;
    
    @NotBlank(message="Marca obrigatoria")
    @Size(min=2, message="Digite um nome com no marca 2 caracteres")
    private String marca;
    
    @NotNull(message="Valor obrigatorio")
    @Min(1)
    private double valor;
    
    @NotBlank(message="Validade obrigatoria")
    private String data;
    
    @NotNull(message="Quantidade obrigatoria")
    @Min(1)
    private Integer quantidade;
    
    
}
