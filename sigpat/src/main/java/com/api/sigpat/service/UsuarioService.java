package com.api.sigpat.service;

import com.api.sigpat.model.Usuario;
import com.api.sigpat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
