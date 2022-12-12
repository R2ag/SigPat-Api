package com.api.sigpat.service;

import com.api.sigpat.model.Ativo;
import com.api.sigpat.model.TipoAtivo;
import com.api.sigpat.repository.TipoAtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoAtivoService {
    @Autowired
    TipoAtivoRepository tipoAtivoRepository;

    @Transactional
    public TipoAtivo save(TipoAtivo tipoAtivo){
        return tipoAtivoRepository.save(tipoAtivo);
    }

    public Page<TipoAtivo> findAll(Pageable page){
        return tipoAtivoRepository.findAll(page);
    }

    public Optional<TipoAtivo> findById(Long id){
        return tipoAtivoRepository.findById(id);
    }

    @Transactional
    public void delete(TipoAtivo tipoAtivo){
        tipoAtivoRepository.delete(tipoAtivo);
    }

}
