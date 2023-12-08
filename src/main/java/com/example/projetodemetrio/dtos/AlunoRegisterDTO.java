package com.example.projetodemetrio.dtos;

public record AlunoRegisterDTO(
    String matricula,
    String nome,
    String cpf,
	String curso,
    Long endereco
) {}
