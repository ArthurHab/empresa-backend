package com.example.projetodemetrio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.EnderecoAlterarDTO;
import com.example.projetodemetrio.dtos.EnderecoDTO;
import com.example.projetodemetrio.models.Endereco;
import com.example.projetodemetrio.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    public ResponseEntity<?> enderecosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.findAll());
    }

    public ResponseEntity<?> enderecoPorId(Long id){
        if(enderecoRepository.existsById(id) == false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereco não encontrado!");
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não encontrado!");
    }    

    public ResponseEntity<?> enderecosDeletar(Long id){

        try {
            if(enderecoRepository.existsById(id) == true){
                enderecoRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Endereço excluído com sucesso!");
            }
  
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não encontrado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Somente é possível deletar um endereço depois de deletar todos os dados que possuem vínculo com ele!");
        }
    }
}
