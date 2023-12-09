package com.example.projetodemetrio.dtos;

public record ProjetoAlterarDTO(
    Long id,
    String tituloProjeto,
	String areaProjeto,
	String resumo,
	Long idProfessor,
	Long idAluno,
	String url
) {}