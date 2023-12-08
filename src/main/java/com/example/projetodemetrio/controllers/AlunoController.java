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

import com.example.projetodemetrio.dtos.AlunoRegisterDTO;
import com.example.projetodemetrio.services.AlunoService;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    
    @Autowired
    AlunoService AlunoService;

    @GetMapping("")
    public ResponseEntity<?> AlunosCadastrados(){
        return AlunoService.alunosCadastrados();
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarAluno(@RequestBody @Validated AlunoRegisterDTO alunoRegisterDTO){
        return AlunoService.alunoCadastrar(alunoRegisterDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id){
        return AlunoService.alunoDeletar(id);
    }
}
