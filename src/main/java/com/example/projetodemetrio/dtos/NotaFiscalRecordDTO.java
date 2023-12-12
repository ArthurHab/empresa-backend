package com.example.projetodemetrio.dtos;

import java.sql.Date;

public record NotaFiscalRecordDTO(
    Long numero_nota_fiscal,
    String nome_razao_social, 
    String cnpj,
    Date data_de_emissao,
    Date data_de_entrada_saida,
    String descricao_produto_servico,
    Float valor_nota_fiscal
) {} 
