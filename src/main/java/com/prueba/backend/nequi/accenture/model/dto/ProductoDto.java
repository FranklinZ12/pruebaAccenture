package com.prueba.backend.nequi.accenture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private int cantidadStock;
    private Long IdSucursal;
}
