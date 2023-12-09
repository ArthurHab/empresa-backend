package com.example.projetodemetrio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "projetos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo_projeto")
	private String tituloProjeto;
	
	@Column(name = "area_projeto")
	private String areaProjeto;
	
	@Column(name = "resumo")
	private String resumo;

    @Column(name = "id_professor")
	private Long idProfessor;

    @Column(name = "id_aluno")
	private Long idAluno;

    @Column(name = "url")
	private String url;
}
