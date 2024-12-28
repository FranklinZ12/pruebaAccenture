package com.prueba.backend.nequi.accenture.repository;

import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
