package com.example.projetodemetrio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.ProjetoDTO;
import com.example.projetodemetrio.models.Projeto;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.ProjetoRepository;

@Service
public class ProjetoService {
    
    @Autowired
    ProjetoRepository ProjetoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> ProjetosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(ProjetoRepository.findAll());
    }

    public ResponseEntity<?> ProjetosCadastrar(ProjetoDTO ProjetoDTO){
        Projeto novoProjeto = new Projeto();
        BeanUtils.copyProperties(ProjetoDTO, novoProjeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProjetoRepository.save(novoProjeto));
    }

    public ResponseEntity<?> ProjetosDeletar(Long id){
        if(ProjetoRepository.existsById(id) == true){
            ProjetoRepository.deleteById(id);
            mensagem.setMensagem("Projeto excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        mensagem.setMensagem("Projeto não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }
}
