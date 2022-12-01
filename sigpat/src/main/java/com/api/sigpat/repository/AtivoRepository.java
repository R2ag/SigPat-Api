package com.api.sigpat.repository;

import com.api.sigpat.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AtivoRepository extends JpaRepository<Ativo, UUID> {
}
