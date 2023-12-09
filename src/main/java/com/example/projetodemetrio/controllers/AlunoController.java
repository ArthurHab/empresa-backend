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

import com.example.projetodemetrio.dtos.AlunoAlterarDTO;
import com.example.projetodemetrio.dtos.AlunoRegisterDTO;
import com.example.projetodemetrio.services.AlunoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("aluno")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    @GetMapping("")
    public ResponseEntity<?> alunosCadastrados(){
        return alunoService.alunosCadastrados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> alunoPorId(@PathVariable Long id){
        return alunoService.alunoPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarAluno(@RequestBody @Validated AlunoRegisterDTO alunoRegisterDTO){
        return alunoService.alunoCadastrar(alunoRegisterDTO);
    }

    @PutMapping("")
    public ResponseEntity<?> alterarAluno(@RequestBody @Validated AlunoAlterarDTO alunoAlterarDTO){
        return alunoService.alterarDadosAluno(alunoAlterarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id){
        return alunoService.alunoDeletar(id);
    }
}
