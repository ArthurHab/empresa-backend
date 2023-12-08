package com.example.projetodemetrio.dtos;

public record ProjetoAlterarDTO(
    Long id,
    String tituloProjeto,
	String areaProjeto,
	String resumo,
	String idProfessor,
	String idAluno,
	String url
) {}