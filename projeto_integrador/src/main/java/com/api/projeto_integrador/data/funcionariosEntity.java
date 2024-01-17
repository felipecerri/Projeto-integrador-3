package com.api.projeto_integrador.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
    
    @Size(min=3, message="Digite um nome com no minino 2 caracterees")
    private String nome;
    
    @Min(16)
    private Integer idade;
    
    @CPF(message="CPF invalido")
    private String cpf;
    
    private String cargo;
    
    @Min(1300)
    private double salario;
    
}
