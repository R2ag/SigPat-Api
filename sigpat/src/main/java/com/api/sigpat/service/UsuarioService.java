package com.api.sigpat.service;

import com.api.sigpat.model.Ativo;
import com.api.sigpat.model.Usuario;
import com.api.sigpat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> findAll(Pageable page){
        return usuarioRepository.findAll(page);
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
