package com.example.projetodemetrio.dtos;

import com.example.projetodemetrio.models.Endereco;

public record AlunoDTO(
    String matricula,
    String nome,
    String cpf,
	String curso,
    Endereco endereco
) {}
