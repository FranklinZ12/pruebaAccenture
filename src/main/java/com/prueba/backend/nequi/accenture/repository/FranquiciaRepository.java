package com.prueba.backend.nequi.accenture.repository;

import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
    Optional<Franquicia> findByNombre(String nombre);
}
