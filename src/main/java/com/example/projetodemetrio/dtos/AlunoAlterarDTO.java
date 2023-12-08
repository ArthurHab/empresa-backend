package com.example.projetodemetrio.dtos;

public record AlunoAlterarDTO(
    Long id,
    String matricula,
    String nome,
    String cpf,
	String curso,
    Long endereco
) {}
