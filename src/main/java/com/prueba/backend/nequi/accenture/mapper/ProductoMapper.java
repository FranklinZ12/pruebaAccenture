package com.prueba.backend.nequi.accenture.mapper;

import com.prueba.backend.nequi.accenture.model.dto.ProductoDto;
import com.prueba.backend.nequi.accenture.model.entity.Producto;
import com.prueba.backend.nequi.accenture.model.entity.Sucursal;

public class ProductoMapper {
    public static ProductoDto mapToProductoDto (Producto producto, ProductoDto productoDto){
        productoDto.setNombre(producto.getNombre());
        productoDto.setCantidadStock(producto.getCantidadStock());
        if (producto.getSucursal() != null) {
            productoDto.setIdSucursal(producto.getSucursal().getId());
        }
        return productoDto;
    }


    public static Producto mapToProducto(ProductoDto productoDto, Producto producto){
        producto.setNombre(productoDto.getNombre());
        producto.setCantidadStock(productoDto.getCantidadStock());
        if (productoDto.getIdSucursal() != null) {
            Sucursal sucursal = new Sucursal();
            sucursal.setId(productoDto.getIdSucursal());
            producto.setSucursal(sucursal);
        }
        return producto;
    }
}
