package com.prueba.backend.nequi.accenture.controller;

import com.prueba.backend.nequi.accenture.constants.FranquiciaConstants;
import com.prueba.backend.nequi.accenture.constants.SucursalConstants;
import com.prueba.backend.nequi.accenture.model.dto.ResponseDto;
import com.prueba.backend.nequi.accenture.model.dto.SucursalRequest;
import com.prueba.backend.nequi.accenture.services.ISucursalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sucursal", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class SucursalController {
    private ISucursalService iSucursalService;
    @PostMapping("/crear")
    public ResponseEntity<ResponseDto> crearSucursal(@RequestBody SucursalRequest sucursalRequest) {
        iSucursalService.crearSucursal(sucursalRequest.getNombreSucursal(), sucursalRequest.getIdFranquicia());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(FranquiciaConstants.STATUS_201, SucursalConstants.MESSAGE_201));
    }
}
