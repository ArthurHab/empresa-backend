package com.example.projetodemetrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetodemetrio.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
