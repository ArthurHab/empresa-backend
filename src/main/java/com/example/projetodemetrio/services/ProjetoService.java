package com.example.projetodemetrio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.ProjetoAlterarDTO;
import com.example.projetodemetrio.dtos.ProjetoDTO;
import com.example.projetodemetrio.models.Projeto;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.ProjetoRepository;

@Service
public class ProjetoService {
    
    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> ProjetosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.findAll());
    }

    public ResponseEntity<?> projetoPorId(Long id){
        if(projetoRepository.existsById(id) == false){
            mensagem.setMensagem("projeto não encontrado!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.findById(id));
    }

    public ResponseEntity<?> ProjetosCadastrar(ProjetoDTO ProjetoDTO){
        Projeto novoProjeto = new Projeto();
        BeanUtils.copyProperties(ProjetoDTO, novoProjeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoRepository.save(novoProjeto));
    }

    public ResponseEntity<?> alterarDadosProjeto(ProjetoAlterarDTO projetoAlterarDTO){
        if(projetoRepository.existsById(projetoAlterarDTO.id()) == true){
            Projeto projetoAlterado = new Projeto();
            BeanUtils.copyProperties( projetoAlterarDTO, projetoAlterado);
            return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.save(projetoAlterado));
        }
        mensagem.setMensagem("Professor não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }    

    public ResponseEntity<?> ProjetosDeletar(Long id){
        if(projetoRepository.existsById(id) == true){
            projetoRepository.deleteById(id);
            mensagem.setMensagem("Projeto excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        mensagem.setMensagem("Projeto não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }
}
