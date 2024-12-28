package com.prueba.backend.nequi.accenture.model.dto;

import com.prueba.backend.nequi.accenture.model.entity.Sucursal;
import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;
    private int cantidadStock;
    private Sucursal sucursal;
}
