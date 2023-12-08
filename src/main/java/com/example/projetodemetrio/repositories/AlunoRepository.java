package com.example.projetodemetrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetodemetrio.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
