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

import com.example.projetodemetrio.dtos.EnderecoAlterarDTO;
import com.example.projetodemetrio.dtos.EnderecoDTO;
import com.example.projetodemetrio.services.EnderecoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("endereco")
public class EnderecoController {
    
    @Autowired
    EnderecoService enderecoService;

    @GetMapping("")
    public ResponseEntity<?> EnderecosCadastrados(){
        return enderecoService.enderecosCadastrados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> enderecoPorId(@PathVariable Long id){
        return enderecoService.enderecoPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody @Validated EnderecoDTO EnderecoDTO){
        return enderecoService.enderecosCadastrar(EnderecoDTO);
    }

    @PutMapping("")
    public ResponseEntity<?> alterarEndereco(@RequestBody @Validated EnderecoAlterarDTO enderecoAlterarDTO){
        return enderecoService.alterarDadosEndereco(enderecoAlterarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id){
        return enderecoService.enderecosDeletar(id);
    }
}
