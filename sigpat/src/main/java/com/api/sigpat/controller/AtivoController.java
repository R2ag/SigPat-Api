package com.api.sigpat.controller;

import com.api.sigpat.DTO.AtivoDTO;
import com.api.sigpat.model.Ativo;
import com.api.sigpat.service.AtivoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

}
