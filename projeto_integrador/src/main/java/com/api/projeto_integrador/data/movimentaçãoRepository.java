package com.api.projeto_integrador.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movimentaçãoRepository extends JpaRepository<movimentaçãoEntity, Integer>{
    
}
