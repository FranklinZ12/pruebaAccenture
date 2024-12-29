package com.prueba.backend.nequi.accenture.services.impl;

import com.prueba.backend.nequi.accenture.exception.FranquiciaAlredyExistsException;
import com.prueba.backend.nequi.accenture.mapper.ProductoMapper;
import com.prueba.backend.nequi.accenture.model.dto.ProductoDto;
import com.prueba.backend.nequi.accenture.model.entity.Producto;
import com.prueba.backend.nequi.accenture.model.entity.Sucursal;
import com.prueba.backend.nequi.accenture.repository.ProductoRepository;
import com.prueba.backend.nequi.accenture.repository.SucursalRepository;
import com.prueba.backend.nequi.accenture.services.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {
    private SucursalRepository sucursalRepository;
    private ProductoRepository productoRepository;
    /**
     * @param sucursalID
     * @param nombreProducto
     * @param stock
     * @return
     */
    @Override
    public ProductoDto agregarProductoSucursal(Long sucursalID, String nombreProducto, int stock) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(sucursalID);
        if (optionalSucursal.isEmpty()) {
            throw new FranquiciaAlredyExistsException("Sucursal no encontrada con el iD: " + sucursalID);
        }

        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new FranquiciaAlredyExistsException("El nombre del producto no puede estar vacío");
        }

        if (stock < 0) {
            throw new FranquiciaAlredyExistsException("El stock no puede ser negativo");
        }

        Optional<Producto> productoExistente = optionalSucursal.get().getProductos().stream().filter(p -> p.getNombre().equals(nombreProducto)).findFirst();
        if (productoExistente.isPresent()) {
            throw new FranquiciaAlredyExistsException("Ya existe un producto con el nombre: " + nombreProducto);
        }

        Producto productoNuevo = new Producto();
        productoNuevo.setNombre(nombreProducto);
        productoNuevo.setCantidadStock(stock);
        productoNuevo.setSucursal(optionalSucursal.get());
        productoNuevo.setCreatedBy("DevFranklin");
        productoNuevo.setCreatedAt(LocalDateTime.now());
        optionalSucursal.get().getProductos().add(productoNuevo);

        productoRepository.save(productoNuevo);

        return ProductoMapper.mapToProductoDto(productoNuevo, new ProductoDto());
    }

    /**
     * Eliminar un producto por el ID
     * @param productoID
     * @return
     */
    @Override
    public ProductoDto eliminarProducto(Long productoID) {
        Optional<Producto> optionalProducto = productoRepository.findById(productoID);
        if (optionalProducto.isEmpty()) {
            throw new FranquiciaAlredyExistsException("Producto no encontrado con el ID: " + productoID);
        }
        Producto producto = optionalProducto.get();
        productoRepository.delete(producto);
        return ProductoMapper.mapToProductoDto(producto, new ProductoDto());
    }

    /**
     * @param productoID
     * @param stock
     * @return
     */
    @Override
    public boolean actualizarStock(Long productoID, int stock) {
        boolean isUpdated = false;

        Optional<Producto> optionalProducto = productoRepository.findById(productoID);
        if (optionalProducto.isEmpty()) {
            throw new FranquiciaAlredyExistsException("Producto no encontrado con el ID: " + productoID);
        }

        Producto producto = optionalProducto.get();
        producto.setCantidadStock(stock);
        producto.setUpdatedBy("DevFranklin");
        producto.setUpdatedAt(LocalDateTime.now());
        productoRepository.save(producto);
        isUpdated = true;
        return isUpdated;
    }
}
