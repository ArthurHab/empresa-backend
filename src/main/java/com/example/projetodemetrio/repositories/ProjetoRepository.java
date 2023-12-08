package com.example.projetodemetrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetodemetrio.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    
}
