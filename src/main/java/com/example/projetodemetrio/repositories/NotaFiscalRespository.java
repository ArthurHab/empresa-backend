package com.example.projetodemetrio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetodemetrio.models.NotaFiscal;

public interface NotaFiscalRespository extends JpaRepository<NotaFiscal, Long> {
    
}
