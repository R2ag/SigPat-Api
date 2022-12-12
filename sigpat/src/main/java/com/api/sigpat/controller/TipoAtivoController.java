package com.api.sigpat.controller;

import com.api.sigpat.DTO.AtivoDTO;
import com.api.sigpat.DTO.TipoAtivoDTO;
import com.api.sigpat.model.Ativo;
import com.api.sigpat.model.TipoAtivo;
import com.api.sigpat.service.TipoAtivoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/tipousuario")
public class TipoAtivoController {
    @Autowired
    TipoAtivoService tipoAtivoService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Object> saveTipoAtivo(@RequestBody @Valid TipoAtivoDTO tipoAtivoDTO){
        var tipoAtivo = new TipoAtivo();
        BeanUtils.copyProperties(tipoAtivoDTO, tipoAtivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoAtivoService.save(tipoAtivo));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Object> findAllTiposAtivo(Pageable page){
        return ResponseEntity.ok().body(tipoAtivoService.findAll(page));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipoAtivoById(@PathVariable(value = "id") Long id){
        Optional<TipoAtivo> tipoAtivoOptional = tipoAtivoService.findById(id);
        if(!tipoAtivoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Não Encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tipoAtivoOptional.get());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoAtivo(@PathVariable(value = "id") Long id){
        Optional<TipoAtivo> tipoAtivoOptional = tipoAtivoService.findById(id);
        if (!tipoAtivoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Não Encontrado!");
        }

        tipoAtivoService.delete(tipoAtivoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com Sucesso!");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTipoAtivo(@PathVariable(value = "id") Long id, @RequestBody @Valid TipoAtivoDTO tipoAtivoDTO){
        Optional<TipoAtivo> tipoAtivoOptional = tipoAtivoService.findById(id);
        if (!tipoAtivoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ativo Não Encontrado!");
        }

        var tipoAtivo = new TipoAtivo();
        BeanUtils.copyProperties(tipoAtivo, tipoAtivo);
        tipoAtivo.setId(tipoAtivoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(tipoAtivoService.save(tipoAtivo));
    }

}
