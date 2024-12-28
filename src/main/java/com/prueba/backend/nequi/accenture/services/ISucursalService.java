package com.prueba.backend.nequi.accenture.services;

import com.prueba.backend.nequi.accenture.model.dto.FranquiciaDto;
import com.prueba.backend.nequi.accenture.model.dto.SucursalDto;

public interface ISucursalService {

    SucursalDto crearSucursal(SucursalDto sucursaldto,  FranquiciaDto franquiciaDto);
}
