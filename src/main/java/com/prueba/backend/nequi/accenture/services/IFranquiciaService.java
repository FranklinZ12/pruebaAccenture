package com.prueba.backend.nequi.accenture.services;

import com.prueba.backend.nequi.accenture.model.dto.FranquiciaDto;

import java.util.List;

public interface IFranquiciaService {

    /**
     * Este metodo agrega una nueva franquicia
     * @param franquiciaDto
     * @return
     */
    void creaFranquicia(FranquiciaDto franquiciaDto);

    List<FranquiciaDto> obtenerFranquicias();
}
