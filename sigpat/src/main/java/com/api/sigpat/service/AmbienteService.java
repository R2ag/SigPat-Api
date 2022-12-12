package com.api.sigpat.service;

import com.api.sigpat.model.Ambiente;
import com.api.sigpat.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AmbienteService {

    @Autowired
    AmbienteRepository ambienteRepository;

    @Transactional
    public Ambiente save(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    public Page<Ambiente> findAll(Pageable page){
        return  ambienteRepository.findAll(page);
    }

    public Optional<Ambiente> findById(Long id) {
        return ambienteRepository.findById(id);
    }
    @Transactional
    public void delete(Ambiente ambiente) {
        ambienteRepository.delete(ambiente);
    }
}
