package com.prueba.backend.nequi.accenture.repository;

import com.prueba.backend.nequi.accenture.model.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
