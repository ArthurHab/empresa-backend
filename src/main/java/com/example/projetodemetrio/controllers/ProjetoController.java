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

import com.example.projetodemetrio.dtos.ProjetoDTO;
import com.example.projetodemetrio.services.ProjetoService;

@RestController
@RequestMapping("projeto")
public class ProjetoController {
    
    @Autowired
    ProjetoService projetoService;

    @GetMapping("")
    public ResponseEntity<?> projetosCadastrados(){
        return projetoService.ProjetosCadastrados();
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarProjeto(@RequestBody @Validated ProjetoDTO projetoDTO){
        return projetoService.ProjetosCadastrar(projetoDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
        return projetoService.ProjetosDeletar(id);
    }
}
