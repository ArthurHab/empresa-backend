package com.example.projetodemetrio.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.DeletarIdDTO;
import com.example.projetodemetrio.dtos.ProfessorAlterarDTO;
import com.example.projetodemetrio.dtos.ProfessorRegisterDTO;
import com.example.projetodemetrio.models.Professor;
import com.example.projetodemetrio.models.Endereco;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.ProfessorRepository;
import com.example.projetodemetrio.repositories.EnderecoRepository;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> professorsCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findAll());
    }

    public ResponseEntity<?> professorPorId(Long id){
        if(professorRepository.existsById(id) == false){
            mensagem.setMensagem("professor não encontrado!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findById(id));
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
        return ResponseEntity.status(HttpStatus.CREATED).body(professorRepository.save(novoProfessor));
    }

    public ResponseEntity<?> alterarDadosProfessor(ProfessorAlterarDTO professorAlterarDTO){
        if(professorRepository.existsById(professorAlterarDTO.id()) == true){
            Professor professorAlterado = new Professor();
            BeanUtils.copyProperties( professorAlterarDTO, professorAlterado);
            professorAlterado.setEndereco(enderecoRepository.findById(professorAlterarDTO.endereco()).get());
            return ResponseEntity.status(HttpStatus.OK).body(professorRepository.save(professorAlterado));
        }
        mensagem.setMensagem("Professor não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }    

    public ResponseEntity<?> professorDeletar(DeletarIdDTO deletarIdDTO){
        if(professorRepository.existsById(deletarIdDTO.id())){
            professorRepository.deleteById(deletarIdDTO.id());
            mensagem.setMensagem("Professor excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        mensagem.setMensagem("Professor não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }

}
