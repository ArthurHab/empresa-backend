package com.example.projetodemetrio.dtos;

public record ProjetoDTO(
	String tituloProjeto,
	String areaProjeto,
	String resumo,
	Long idProfessor,
	Long idAluno,
	String url
) {}
