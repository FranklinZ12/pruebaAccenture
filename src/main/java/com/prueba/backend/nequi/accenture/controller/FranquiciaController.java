package com.prueba.backend.nequi.accenture.controller;

import com.prueba.backend.nequi.accenture.constants.FranquiciaConstants;
import com.prueba.backend.nequi.accenture.model.dto.FranquiciaDto;
import com.prueba.backend.nequi.accenture.model.dto.ResponseDto;
import com.prueba.backend.nequi.accenture.services.IFranquiciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/franquicia", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class FranquiciaController {

    private IFranquiciaService iFranquiciaService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseDto> crearFranquicia(@RequestBody FranquiciaDto franquiciaDto){
        iFranquiciaService.creaFranquicia(franquiciaDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(FranquiciaConstants.STATUS_201, FranquiciaConstants.MESSAGE_201));
    }
}
