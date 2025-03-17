package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.services.ProductoServices;
import com.ucompensar.tienda.services.dto.ProductoDto;
import com.ucompensar.tienda.services.dto.ProductoPostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoServices productoServices;

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
