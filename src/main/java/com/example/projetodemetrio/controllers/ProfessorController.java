package com.example.projetodemetrio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetodemetrio.dtos.ProfessorAlterarDTO;
import com.example.projetodemetrio.dtos.ProfessorRegisterDTO;
import com.example.projetodemetrio.services.ProfessorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("professor")
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;

    @GetMapping("")
    public ResponseEntity<?> professorsCadastrados(){
        return professorService.professorsCadastrados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> professorPorId(@PathVariable Long id){
        return professorService.professorPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarProfessor(@RequestBody @Validated ProfessorRegisterDTO ProfessorRegisterDTO){
        return professorService.professorCadastrar(ProfessorRegisterDTO);
    }

    @PutMapping("")
    public ResponseEntity<?> alterarProfessor(@RequestBody @Validated ProfessorAlterarDTO professorAlterarDTO){
        return professorService.alterarDadosProfessor(professorAlterarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProfessor(@PathVariable Long id){
        return professorService.professorDeletar(id);
    }
}
