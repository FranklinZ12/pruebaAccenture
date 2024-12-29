package com.prueba.backend.nequi.accenture.model.dto;

import lombok.Data;

@Data
public class ProductoRequest {
    private Long idProducto;
    private String nombreProducto;
    private Long idSucursal;
    private int stock;
}
