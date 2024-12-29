package com.prueba.backend.nequi.accenture.repository;

import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import com.prueba.backend.nequi.accenture.model.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    Optional<Sucursal> findByNombreAndFranquicia(String nombre, Franquicia franquicia);

    List<Sucursal> findByFranquicia(Franquicia franquicia);
}
