package com.example.projetodemetrio.dtos;

import com.example.projetodemetrio.models.Endereco;

public record ProfessorDTO(
	String matricula,
	String nome,
	String curso,
    Endereco endereco
) {}