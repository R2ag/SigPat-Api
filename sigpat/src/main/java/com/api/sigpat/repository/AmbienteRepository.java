package com.api.sigpat.repository;

import com.api.sigpat.model.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {
}
