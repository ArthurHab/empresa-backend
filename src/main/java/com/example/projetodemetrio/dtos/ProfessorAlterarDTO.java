package com.example.projetodemetrio.dtos;

public record ProfessorAlterarDTO(
    Long id,
	String matricula,
	String nome,
	String curso,
    Long endereco
) {}
