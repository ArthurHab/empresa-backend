package com.example.projetodemetrio.dtos;

import java.sql.Date;

public record NotaFiscalRecordDTO(
    Long numeroNotaFiscal,
    String nomeRazaoSocial, 
    String cnpj,
    Date dataDeEmissao,
    Date dataDeEntradaSaida,
    String descricaoProdutoServico,
    Float valorNotaFiscal
) {} 
