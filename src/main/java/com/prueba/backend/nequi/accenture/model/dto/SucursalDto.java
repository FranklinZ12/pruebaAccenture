package com.prueba.backend.nequi.accenture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class SucursalDto {
    private String nombre;
    private Long franquiciaId;
    private Long sucursalId;
}
