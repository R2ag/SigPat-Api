package com.api.sigpat.repository;

import com.api.sigpat.model.TipoAtivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAtivoRepository extends JpaRepository<TipoAtivo, Long> {
}
