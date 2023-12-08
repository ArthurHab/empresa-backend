package com.example.projetodemetrio.dtos;

public record EnderecoAlterarDTO(
    Long id,
    String rua,
    String numero,
    String cep,
    String cidade,
    String estado,
    String pais
) {}
