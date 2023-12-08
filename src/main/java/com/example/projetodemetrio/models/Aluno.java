package com.example.projetodemetrio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
	private String cpf;
	
	@Column(name = "curso")
	private String curso;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;
}
