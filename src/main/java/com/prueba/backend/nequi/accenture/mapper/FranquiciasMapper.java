package com.prueba.backend.nequi.accenture.mapper;

import com.prueba.backend.nequi.accenture.model.dto.FranquiciaDto;
import com.prueba.backend.nequi.accenture.model.entity.Franquicia;

public class FranquiciasMapper {
    public static FranquiciaDto mapToFranquiciaDto (Franquicia franquicia, FranquiciaDto franquiciaDto){
        franquiciaDto.setNombre(franquicia.getNombre());
        return franquiciaDto;
    }

    public static Franquicia mapToFranquicia(FranquiciaDto franquiciaDto, Franquicia franquicia){
        franquicia.setNombre(franquiciaDto.getNombre());
        return franquicia;
    }

}
