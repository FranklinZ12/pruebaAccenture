package com.prueba.backend.nequi.accenture.controller;

import com.prueba.backend.nequi.accenture.constants.FranquiciaConstants;
import com.prueba.backend.nequi.accenture.constants.ProductoConstants;
import com.prueba.backend.nequi.accenture.model.dto.ProductoRequest;
import com.prueba.backend.nequi.accenture.model.dto.ResponseDto;
import com.prueba.backend.nequi.accenture.services.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/producto", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductoController {
    private IProductoService iProductoService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseDto> crearProducto(@RequestBody ProductoRequest productoRequest) {
        iProductoService.agregarProductoSucursal(productoRequest.getIdSucursal(), productoRequest.getNombreProducto(), productoRequest.getStock());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(FranquiciaConstants.STATUS_201, ProductoConstants.MESSAGE_201));
    }


    @DeleteMapping("/eliminar/{productoID}")
    public ResponseEntity<ResponseDto> eliminarProducto(@PathVariable Long productoID) {
        iProductoService.eliminarProducto(productoID);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(FranquiciaConstants.STATUS_200, FranquiciaConstants.MESSAGE_200));
    }
}
