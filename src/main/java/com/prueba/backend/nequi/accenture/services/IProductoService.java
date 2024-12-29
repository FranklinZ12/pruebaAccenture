package com.prueba.backend.nequi.accenture.services;

import com.prueba.backend.nequi.accenture.model.dto.ProductoDto;

public interface IProductoService {
    ProductoDto agregarProductoSucursal(Long sucursalID, String nombreProducto, int stock);
}
