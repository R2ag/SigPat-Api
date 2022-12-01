package com.api.sigpat.controller;

import com.api.sigpat.DTO.TipoAtivoDTO;
import com.api.sigpat.model.TipoAtivo;
import com.api.sigpat.service.TipoAtivoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/tipousuario")
public class TipoAtivoController {
    @Autowired
    TipoAtivoService tipoAtivoService;

    @PostMapping
    public ResponseEntity<Object> saveTipoAtivo(@RequestBody @Valid TipoAtivoDTO tipoAtivoDTO){
        var tipoAtivo = new TipoAtivo();
        BeanUtils.copyProperties(tipoAtivoDTO, tipoAtivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoAtivoService.save(tipoAtivo));
    }
}
