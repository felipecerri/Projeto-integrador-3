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
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name="funcionarios")
public class funcionariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Nome obrigatorio")
    @Size(min=3, message="Digite um nome com no minino 2 caracterees")
    private String nome;
    
    @NotNull(message="Idade obrigatorio")
    @Min(16)
    private Integer idade;
    
    @NotBlank(message="CPF obrigatorio")
    @CPF(message="CPF invalido")
    private String cpf;
    
    @NotBlank(message="Cargo obrigatorio")
    private String cargo;
    
    @NotNull(message="Salario Obrigatorio")
    private double salario;
    
}
