package com.example.projetodemetrio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.EnderecoAlterarDTO;
import com.example.projetodemetrio.dtos.EnderecoDTO;
import com.example.projetodemetrio.models.Endereco;
import com.example.projetodemetrio.models.Mensagem;
import com.example.projetodemetrio.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> enderecosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.findAll());
    }

    public ResponseEntity<?> enderecoPorId(Long id){
        if(enderecoRepository.existsById(id) == false){
            mensagem.setMensagem("endereco não encontrado!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.findById(id));
    }

    public ResponseEntity<?> enderecosCadastrar(EnderecoDTO enderecoDTO){
        Endereco novoEndereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, novoEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(novoEndereco));
    }

    public ResponseEntity<?> alterarDadosEndereco(EnderecoAlterarDTO enderecoAlterarDTO){
        if(enderecoRepository.existsById(enderecoAlterarDTO.id()) == true){
            Endereco enderecoAlterado = new Endereco();
            BeanUtils.copyProperties( enderecoAlterarDTO, enderecoAlterado);
            return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(enderecoAlterado));
        }
        mensagem.setMensagem("Endereço não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }    

    public ResponseEntity<?> enderecosDeletar(Long id){
        if(enderecoRepository.existsById(id) == true){
            enderecoRepository.deleteById(id);
            mensagem.setMensagem("Veículo excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        mensagem.setMensagem("Veículo não encontrado!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
    }
}
