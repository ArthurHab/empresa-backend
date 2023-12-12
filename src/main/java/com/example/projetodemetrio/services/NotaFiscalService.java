package com.example.projetodemetrio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projetodemetrio.dtos.NotaFiscalRecordDTO;
import com.example.projetodemetrio.dtos.NotaFiscalAlterarRecordDTO;
import com.example.projetodemetrio.models.NotaFiscal;
import com.example.projetodemetrio.repositories.NotaFiscalRespository;

@Service
public class NotaFiscalService {
    
    @Autowired
    NotaFiscalRespository notaFiscalRepository;

    public ResponseEntity<?> notaFiscalsCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(notaFiscalRepository.findAll());
    }

    public ResponseEntity<?> notaFiscalPorId(Long id){
        if(notaFiscalRepository.existsById(id) == false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NotaFiscal não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(notaFiscalRepository.findById(id));
    }

    public ResponseEntity<?> notaFiscalsCadastrar(NotaFiscalRecordDTO NotaFiscalDTO){
        // Lembrar de alterar a data do created_at em toda alteração
        //Lembrar de verificar se a nota fiscal já existe com o número informado!
        NotaFiscal novoNotaFiscal = new NotaFiscal();
        BeanUtils.copyProperties(NotaFiscalDTO, novoNotaFiscal);
        return ResponseEntity.status(HttpStatus.CREATED).body(notaFiscalRepository.save(novoNotaFiscal));
    }

    public ResponseEntity<?> alterarDadosNotaFiscal(NotaFiscalAlterarRecordDTO NotaFiscalAlterarDTO){
        // Lembrar de alterar a data do updated_at em toda alteração
        if(notaFiscalRepository.existsById(NotaFiscalAlterarDTO.id()) == true){
            NotaFiscal NotaFiscalAlterado = new NotaFiscal();
            BeanUtils.copyProperties( NotaFiscalAlterarDTO, NotaFiscalAlterado);
            return ResponseEntity.status(HttpStatus.OK).body(notaFiscalRepository.save(NotaFiscalAlterado));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota fiscal não encontrado!");
    }    

    public ResponseEntity<?> notaFiscalsDeletar(Long id){
        try {
            if(notaFiscalRepository.existsById(id) == true){
                notaFiscalRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Nota fiscal excluído com sucesso!");
            }
  
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota fiscal não encontrado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Somente é possível deletar um Nota fiscal depois de deletar todos os dados que possuem vínculo com ele!");
        }
    }

    public ResponseEntity<?> notaFiscalDesativar(Long id){
        if(notaFiscalRepository.existsById(id) == true){
            NotaFiscal notaFiscalAtivada = notaFiscalRepository.findById(id).get();
            NotaFiscal notaFiscalDesativada = new NotaFiscal();
            BeanUtils.copyProperties( notaFiscalAtivada, notaFiscalDesativada);
            notaFiscalDesativada.setAtivo(false);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Nota fiscal desativada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota fiscal não encontrado!");
    }
}
