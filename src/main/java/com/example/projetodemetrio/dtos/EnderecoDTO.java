package com.example.projetodemetrio.dtos;

public record EnderecoDTO (
    String rua,
    String numero,
    String cep,
    String cidade,
    String estado,
    String pais
){}

/*
 * Lembrar de colocar o @NonNull !
 */