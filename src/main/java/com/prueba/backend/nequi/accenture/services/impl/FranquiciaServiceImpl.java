package com.prueba.backend.nequi.accenture.services.impl;

import com.prueba.backend.nequi.accenture.exception.FranquiciaAlredyExistsException;
import com.prueba.backend.nequi.accenture.mapper.FranquiciasMapper;
import com.prueba.backend.nequi.accenture.model.dto.FranquiciaDto;
import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import com.prueba.backend.nequi.accenture.repository.FranquiciaRepository;
import com.prueba.backend.nequi.accenture.services.IFranquiciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FranquiciaServiceImpl implements IFranquiciaService {
    private FranquiciaRepository franquiciaRepository;

    /**
     * Este metodo agrega una nueva franquicia
     *
     * @param franquiciaDto
     * @return
     */
    @Override
    public void creaFranquicia(FranquiciaDto franquiciaDto) {
        Franquicia franquicia = FranquiciasMapper
                .mapToFranquicia(franquiciaDto, new Franquicia());
        Optional<Franquicia> optionalFranquicia = franquiciaRepository.findByNombre(franquiciaDto.getNombre());
        if(optionalFranquicia.isPresent()) {
            throw new FranquiciaAlredyExistsException("El nombre de la franquicia ya existe"+ franquiciaDto.getNombre());
        }
        franquicia.setCreatedBy("DevFranklin");
        franquicia.setCreatedAt(LocalDateTime.now());
        franquiciaRepository.save(franquicia);
    }
}
