package com.api.sigpat.service;

import com.api.sigpat.model.TipoAtivo;
import com.api.sigpat.repository.TipoAtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TipoAtivoService {
    @Autowired
    TipoAtivoRepository tipoAtivoRepository;

    @Transactional
    public TipoAtivo save(TipoAtivo tipoAtivo){
        return tipoAtivoRepository.save(tipoAtivo);
    }
}
