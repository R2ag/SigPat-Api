package com.api.sigpat.controller;

import com.api.sigpat.DTO.AmbienteDTO;
import com.api.sigpat.DTO.AtivoDTO;
import com.api.sigpat.model.Ambiente;
import com.api.sigpat.model.Ativo;
import com.api.sigpat.service.AtivoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/ativo")
public class AtivoController {
    @Autowired
    AtivoService ativoService;

    @PostMapping
    public ResponseEntity<Object> saveAtivo(@RequestBody @Valid AtivoDTO ativoDTO){
        var ativo = new Ativo();
        BeanUtils.copyProperties(ativoDTO, ativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(ativoService.save(ativo));
    }

    @GetMapping
    public ResponseEntity<Object> findAllAtivos(Pageable page){
        return ResponseEntity.ok().body(ativoService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAtivoById(@PathVariable(value = "id") UUID id){
        Optional<Ativo> ativoOptional = ativoService.findById(id);
        if (!ativoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ativo Nao Encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ativoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAtivo(@PathVariable(value = "id")UUID id){
        Optional<Ativo> ativoOptional = ativoService.findById(id);
        if (!ativoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ativo Não Encontrado!");
        }

        ativoService.delete(ativoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com Sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAtivo(@PathVariable(value = "id") UUID id, @RequestBody @Valid AtivoDTO ativoDTO){
        Optional<Ativo> ativoOptional = ativoService.findById(id);
        if (!ativoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ativo Não Encontrado!");
        }

        var ativo = new Ativo();
        BeanUtils.copyProperties(ativoDTO, ativo);
        ativo.setId(ativoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(ativoService.save(ativo));
    }
}