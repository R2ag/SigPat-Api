package com.api.sigpat.service;

import com.api.sigpat.model.Ativo;
import com.api.sigpat.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AtivoService {
    @Autowired
    AtivoRepository ativoRepository;

    @Transactional
    public Ativo save(Ativo ativo) {
        return ativoRepository.save(ativo);
    }
}
