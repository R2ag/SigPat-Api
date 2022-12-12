package com.api.sigpat.controller;

import com.api.sigpat.DTO.AmbienteDTO;
import com.api.sigpat.model.Ambiente;
import com.api.sigpat.service.AmbienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/ambiente")
public class AmbienteController {
    @Autowired
    AmbienteService ambienteService;

    @PostMapping
    public ResponseEntity<Object> saveAmbiente(@RequestBody @Valid AmbienteDTO ambienteDTO){
        var ambiente = new Ambiente();
        BeanUtils.copyProperties(ambienteDTO, ambiente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ambienteService.save(ambiente));
    }

    @GetMapping
    public ResponseEntity<Object> findAllAmbientes(Pageable page){
        return ResponseEntity.ok().body(ambienteService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAmbienteById(@PathVariable(value = "id") Long id){
        Optional<Ambiente> ambienteOptional = ambienteService.findById(id);
        if (!ambienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ambiente Nao Encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ambienteOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAmbiente(@PathVariable(value = "id")Long id){
        Optional<Ambiente> ambienteOptional = ambienteService.findById(id);
        if (!ambienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ambiente Não Encontrado!");
        }

        ambienteService.delete(ambienteOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Deletado com Sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAmbiente(@PathVariable(value = "id") Long id, @RequestBody @Valid AmbienteDTO ambienteDTO){
        Optional<Ambiente> ambienteOptional = ambienteService.findById(id);
        if (!ambienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ambiente Não Encontrado!");
        }

        var ambiente = new Ambiente();
        BeanUtils.copyProperties(ambienteDTO, ambiente);
        ambiente.setId(ambienteOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(ambienteService.save(ambiente));
    }
}
