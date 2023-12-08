package com.example.projetodemetrio.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.ProfessorRegisterDTO;
import com.example.projetodemetrio.models.Professor;
import com.example.projetodemetrio.models.Endereco;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.ProfessorRepository;
import com.example.projetodemetrio.repositories.EnderecoRepository;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository ProfessorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> professorsCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(ProfessorRepository.findAll());
    }

    public ResponseEntity<?> professorCadastrar(ProfessorRegisterDTO ProfessorRegisterDTO){
        if(enderecoRepository.existsById(ProfessorRegisterDTO.endereco()) == false){
            mensagem.setMensagem("Esse endereço não está cadastrado no sistema!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        Optional<Endereco> endereco = enderecoRepository.findById(ProfessorRegisterDTO.endereco());
        Professor novoProfessor = new Professor();
        BeanUtils.copyProperties(ProfessorRegisterDTO, novoProfessor);
        novoProfessor.setEndereco(endereco.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfessorRepository.save(novoProfessor));
    }

    //falta fazer o alterar e o encontrar Professor por ID

    public ResponseEntity<?> professorDeletar(Long id){
        if(ProfessorRepository.existsById(id)){
            ProfessorRepository.deleteById(id);
            mensagem.setMensagem("Professor excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        mensagem.setMensagem("Professor não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }

}
