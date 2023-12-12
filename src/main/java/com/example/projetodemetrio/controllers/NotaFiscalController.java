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

import com.example.projetodemetrio.dtos.NotaFiscalAlterarRecordDTO;
import com.example.projetodemetrio.dtos.NotaFiscalRecordDTO;
import com.example.projetodemetrio.services.NotaFiscalService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("nota_fiscal")
public class NotaFiscalController {
    
    @Autowired
    NotaFiscalService notaFiscalService;

    @GetMapping("")
    public ResponseEntity<?> NotaFiscalsCadastrados(){
        return notaFiscalService.notaFiscalsCadastrados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> NotaFiscalPorId(@PathVariable Long id){
        return notaFiscalService.notaFiscalPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<?> cadastrarNotaFiscal(@RequestBody @Validated NotaFiscalRecordDTO NotaFiscalDTO){
        return notaFiscalService.notaFiscalsCadastrar(NotaFiscalDTO);
    }

    @PutMapping("")
    public ResponseEntity<?> alterarNotaFiscal(@RequestBody @Validated NotaFiscalAlterarRecordDTO NotaFiscalAlterarDTO){
        return notaFiscalService.alterarDadosNotaFiscal(NotaFiscalAlterarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarNotaFiscal(@PathVariable Long id){
        return notaFiscalService.notaFiscalsDeletar(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> cadastrarNotaFiscal(@PathVariable Long id){
        return notaFiscalService.notaFiscalDesativar(id);
    }
}
