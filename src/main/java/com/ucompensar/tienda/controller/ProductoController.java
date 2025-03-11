package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.services.ProductoServices;
import com.ucompensar.tienda.services.dto.ProductoDto;
import com.ucompensar.tienda.services.dto.ProductoPostDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
//@RequiredArgsConstructor
public class ProductoController {
    // Forma 1
    // Inyectar el servicio de productos, pero es una mala forma de inyectar dependencias
    // @Autowired
    // private ProductoServices productoServices;

    // Forma 2
    // Inyectar el servicio de productos a través del constructor
    private final ProductoServices productoServices;

    @Autowired
    public ProductoController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    // Forma 3
    // Inyectar el servicio con final y la anotacion de lombok @RequiredArgsConstructor
    // private final ProductoServices productoServices;

    // GET todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> getProductos() {
        List<ProductoDto> response = productoServices.getAll();
        return ResponseEntity.ok(response);
    }

    // GET producto por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable("id") Long id) {
        ProductoDto response = productoServices.getDtoById(id);
        return ResponseEntity.ok(response);

    }

    // POST crear producto
    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@Valid @RequestBody ProductoPostDto producto) {
        ProductoDto response = productoServices.create(producto);
        return ResponseEntity.ok(response);
    }

    // PUT actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable("id") Long id, @Valid @RequestBody ProductoDto producto) {
        ProductoDto response =productoServices.update(id, producto);
        return ResponseEntity.ok(response);
    }

    // DELETE borrar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id") Long id) {
        productoServices.delete(id);
        return ResponseEntity.ok().build();
    }

   // @GetMapping("/exception")
    //public ResponseEntity<Void> exception() {
      //  throw new PersonalException("Probando excepciones");
    //}
}
