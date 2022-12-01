package com.api.sigpat.controller;

import com.api.sigpat.DTO.UsuarioDTO;
import com.api.sigpat.model.Usuario;
import com.api.sigpat.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
}
