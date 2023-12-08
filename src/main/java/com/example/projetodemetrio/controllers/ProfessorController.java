package com.example.projetodemetrio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetodemetrio.dtos.ProfessorRegisterDTO;
import com.example.projetodemetrio.services.ProfessorService;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    
    @Autowired
    ProfessorService ProfessorService;

    @GetMapping("")
    public ResponseEntity<?> professorsCadastrados(){
        return ProfessorService.professorsCadastrados();
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarProfessor(@RequestBody @Validated ProfessorRegisterDTO ProfessorRegisterDTO){
        return ProfessorService.professorCadastrar(ProfessorRegisterDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deletarProfessor(@PathVariable Long id){
        return ProfessorService.professorDeletar(id);
    }
}
