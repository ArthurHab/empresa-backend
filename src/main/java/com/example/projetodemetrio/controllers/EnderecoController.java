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

import com.example.projetodemetrio.dtos.EnderecoDTO;
import com.example.projetodemetrio.services.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    
    @Autowired
    EnderecoService EnderecoService;

    @GetMapping("")
    public ResponseEntity<?> EnderecosCadastrados(){
        return EnderecoService.enderecosCadastrados();
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody @Validated EnderecoDTO EnderecoDTO){
        return EnderecoService.enderecosCadastrar(EnderecoDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id){
        return EnderecoService.enderecosDeletar(id);
    }
}
