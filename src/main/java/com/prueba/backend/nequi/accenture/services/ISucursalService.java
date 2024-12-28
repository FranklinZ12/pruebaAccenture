package com.prueba.backend.nequi.accenture.services;


import com.prueba.backend.nequi.accenture.model.dto.SucursalDto;

public interface ISucursalService {

    SucursalDto crearSucursal(String sucursaldto,  Long franquiciaDto);
}
