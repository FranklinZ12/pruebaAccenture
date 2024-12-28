package com.prueba.backend.nequi.accenture.mapper;


import com.prueba.backend.nequi.accenture.model.dto.SucursalDto;
import com.prueba.backend.nequi.accenture.model.entity.Franquicia;
import com.prueba.backend.nequi.accenture.model.entity.Sucursal;

public class SucursalMapper {
    public static SucursalDto mapToSucursalDto (Sucursal sucursal, SucursalDto sucursalDto){
        sucursalDto.setNombre(sucursal.getNombre());
        if (sucursal.getFranquicia() != null) {
            sucursalDto.setFranquiciaId(sucursal.getFranquicia().getId());
        }
        return sucursalDto;
    }


    public static Sucursal mapToSucursal(SucursalDto sucursalDto, Sucursal sucursal){
        sucursal.setNombre(sucursalDto.getNombre());
        if (sucursalDto.getFranquiciaId() != null) {
            Franquicia franquicia = new Franquicia();
            franquicia.setId(sucursalDto.getFranquiciaId());
            sucursal.setFranquicia(franquicia);
        }
        return sucursal;
    }
}
