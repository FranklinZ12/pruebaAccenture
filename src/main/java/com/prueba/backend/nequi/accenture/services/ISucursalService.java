package com.prueba.backend.nequi.accenture.services;


import com.prueba.backend.nequi.accenture.model.dto.SucursalDto;

import java.util.List;

public interface ISucursalService {

    SucursalDto crearSucursal(String sucursaldto,  Long franquiciaDto);

    List<SucursalDto> obtenerSucursales();
}
