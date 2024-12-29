package com.prueba.backend.nequi.accenture.model.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;
    private int cantidadStock;
    private Long IdSucursal;
}
