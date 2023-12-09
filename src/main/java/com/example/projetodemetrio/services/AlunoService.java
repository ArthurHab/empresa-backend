package com.example.projetodemetrio.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.AlunoAlterarDTO;
import com.example.projetodemetrio.dtos.AlunoRegisterDTO;
import com.example.projetodemetrio.models.Aluno;
import com.example.projetodemetrio.models.Endereco;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.AlunoRepository;
import com.example.projetodemetrio.repositories.EnderecoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> alunosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    public ResponseEntity<?> alunoPorId(Long id){
        if(alunoRepository.existsById(id) == false){
            mensagem.setMensagem("Aluno não encontrado!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findById(id));
    }

    public ResponseEntity<?> alunoCadastrar(AlunoRegisterDTO alunoRegisterDTO){
        if(enderecoRepository.existsById(alunoRegisterDTO.endereco()) == false){
            mensagem.setMensagem("Esse endereço não está cadastrado no sistema!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        Optional<Endereco> endereco = enderecoRepository.findById(alunoRegisterDTO.endereco());
        Aluno novoAluno = new Aluno();
        BeanUtils.copyProperties(alunoRegisterDTO, novoAluno);
        novoAluno.setEndereco(endereco.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(novoAluno));
    }

    public ResponseEntity<?> alterarDadosAluno(AlunoAlterarDTO alunoAlterarDTO){
        if(alunoRepository.existsById(alunoAlterarDTO.id()) == true){
            Aluno alunoAlterado = new Aluno();
            BeanUtils.copyProperties( alunoAlterarDTO, alunoAlterado);
            alunoAlterado.setId(alunoAlterarDTO.id());
            alunoAlterado.setEndereco(enderecoRepository.findById(alunoAlterarDTO.endereco()).get());
            return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoAlterado));
        }
        mensagem.setMensagem("Id não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }

    public ResponseEntity<?> alunoDeletar(Long id){

        if(alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            mensagem.setMensagem("Aluno excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }
        
        mensagem.setMensagem("Aluno não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);

    }

}
