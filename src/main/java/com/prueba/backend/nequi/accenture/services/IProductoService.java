package com.prueba.backend.nequi.accenture.services;

import com.prueba.backend.nequi.accenture.model.dto.ProductoDto;
import com.prueba.backend.nequi.accenture.model.dto.ProductoRequest;

import java.util.List;

public interface IProductoService {
    ProductoDto agregarProductoSucursal(Long sucursalID, String nombreProducto, int stock);
    ProductoDto eliminarProducto(Long productoID);
    boolean actualizarStock(Long productoID, int stock);

    List<ProductoRequest> obtenerProductoConMasStockPorFranquicia(Long franquiciaID);

    List<ProductoDto> obtenerProductos();
}
