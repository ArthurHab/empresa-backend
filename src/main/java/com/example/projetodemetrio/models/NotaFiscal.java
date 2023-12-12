package com.example.projetodemetrio.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "nota_fiscal")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotaFiscal {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_nota_fiscal")
    private Long numero_nota_fiscal;

    @Column(name = "nome_razao_social")
    private String nome_razao_social;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "data_de_emissao")
    private Date data_de_emissao;

    @Column(name = "data_de_entrada_saida")
    private Date data_de_entrada_saida;

    @Column(name = "descricao_produto_servico")
    private String descricao_produto_servico;

    @Column(name = "valor_nota_fiscal")
    private Float valor_nota_fiscal;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "created_at")
    private Date created_at;
}
