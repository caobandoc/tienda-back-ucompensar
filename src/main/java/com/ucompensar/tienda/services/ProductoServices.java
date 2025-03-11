package com.ucompensar.tienda.services;

import com.ucompensar.tienda.controller.exception.UserNotFoundException;
import com.ucompensar.tienda.controller.exception.UsernameAlreadyExistsException;
import com.ucompensar.tienda.persistence.entities.Producto;
import com.ucompensar.tienda.persistence.mapper.ProductoMapper;
import com.ucompensar.tienda.persistence.repository.ProductoDao;
import com.ucompensar.tienda.services.dto.ProductoDto;
import com.ucompensar.tienda.services.dto.ProductoPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServices {

    private final ProductoDao productoDao;
    private final ProductoMapper productoMapper;

    public List<ProductoDto> getAll() {
        return productoMapper.toProductosDto(productoDao.findAll());
    }

    public ProductoDto getDtoById(Long id) {
        return productoMapper.toProductoDto(getById(id));
    }

    public Optional<Producto> getById(Long id) {
        return productoDao.findById(id);
    }

    public ProductoDto create(ProductoPostDto producto) {
        Optional<Producto> productoExist = productoDao.findByName(producto.getName());
        if (productoExist.isPresent()) {
            throw new UsernameAlreadyExistsException("El username ya existe");
        }
        Producto productoEntity = productoMapper.toProducto(producto);
        return productoMapper.toProductoDto(productoDao.save(productoEntity));
    }

    public ProductoDto update(Long id, ProductoDto producto) {
        Producto productoUpdate = getById(id).orElse(null);
        if (productoUpdate == null) {
            throw new UserNotFoundException("producto no encontrado");
        }
        productoUpdate.setName(producto.getName());
        productoUpdate.setName(producto.getName());
        productoUpdate.setName(producto.getName());

        return productoMapper.toProductoDto(productoDao.save(productoUpdate));
    }

    public void delete(Long id) {
        Producto producto = getById(id).orElse(null);
        if (producto == null) {
            throw new UserNotFoundException("Producto no encontrado");
        }
        productoDao.delete(producto);
    }
}
