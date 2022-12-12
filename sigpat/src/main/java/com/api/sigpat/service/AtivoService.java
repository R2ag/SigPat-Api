package com.api.sigpat.service;

import com.api.sigpat.model.Ativo;
import com.api.sigpat.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtivoService {
    @Autowired
    AtivoRepository ativoRepository;

    @Transactional
    public Ativo save(Ativo ativo) {
        return ativoRepository.save(ativo);
    }

    public Page<Ativo> findAll(Pageable page){
        return ativoRepository.findAll(page);
    }

    public Optional<Ativo> findById(UUID id){
        return ativoRepository.findById(id);
    }

    @Transactional
    public void delete(Ativo ativo){
        ativoRepository.delete(ativo);
    }
}
