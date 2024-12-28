package com.prueba.backend.nequi.accenture.services.impl;

import com.prueba.backend.nequi.accenture.exception.FranquiciaAlredyExistsException;
import com.prueba.backend.nequi.accenture.mapper.SucursalMapper;
import com.prueba.backend.nequi.accenture.model.dto.SucursalDto;
import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import com.prueba.backend.nequi.accenture.model.entity.Sucursal;
import com.prueba.backend.nequi.accenture.repository.FranquiciaRepository;
import com.prueba.backend.nequi.accenture.repository.SucursalRepository;
import com.prueba.backend.nequi.accenture.services.ISucursalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SucursalService implements ISucursalService {
    private SucursalRepository sucursalRepository;
    private FranquiciaRepository franquiciaRepository;
    /**
     * metodo que crea una sucursal, asociandole una franquicia
     * @param nombreSucursal
     * @param idFranquicia
     * @return SucursalDto
     */
    @Override
    public SucursalDto crearSucursal(String nombreSucursal, Long idFranquicia) {
        Optional<Franquicia> optionalFranquicia = franquiciaRepository.findById(idFranquicia);
        if (optionalFranquicia.isEmpty()) {
            throw new FranquiciaAlredyExistsException("Franquicia no encontrada con el nombre: " + idFranquicia);
        }


        Franquicia franquicia = optionalFranquicia.get();

        Optional<Sucursal> optionalSucursal = sucursalRepository.findByNombreAndFranquicia(nombreSucursal, franquicia);
        if (optionalSucursal.isPresent()) {
            throw new FranquiciaAlredyExistsException("Ya existe una sucursal con el nombre: " + nombreSucursal+
                    " en la franquicia con ID: " + idFranquicia);
        }

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombreSucursal);
        sucursal.setFranquicia(franquicia);
        sucursal.setCreatedBy("DevFranklin");
        sucursal.setCreatedAt(LocalDateTime.now());

        Sucursal sucursalGuardada = sucursalRepository.save(sucursal);

        return SucursalMapper.mapToSucursalDto(sucursalGuardada, new SucursalDto());
    }

}
