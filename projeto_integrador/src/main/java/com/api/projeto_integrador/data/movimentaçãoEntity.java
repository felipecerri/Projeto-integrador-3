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
@Table(name="movimentações")
public class movimentaçãoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Size(min=2, message="Digite uma descrição com no minimo 2 caracteres")
    private String descr;
    
    @Min(0)
    private double valor;
    private String data;
    private boolean entrada;
    
}
