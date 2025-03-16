package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.services.CategoriaServices;
import com.ucompensar.tienda.services.dto.CategoriaDto;
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
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CategoriaController {

        private final CategoriaServices categoriaServices;

        @GetMapping
        public ResponseEntity<List<CategoriaDto>> findAll() {
            return ResponseEntity.ok(categoriaServices.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CategoriaDto> findById(@PathVariable Long id) {
            return ResponseEntity.ok(categoriaServices.findById(id));
        }

        @PostMapping
        public ResponseEntity<CategoriaDto> create(@Valid @RequestBody CategoriaDto categoriaDto) {
            return ResponseEntity.ok(categoriaServices.create(categoriaDto));
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @Valid @RequestBody CategoriaDto categoriaDto) {
            return ResponseEntity.ok(categoriaServices.update(id, categoriaDto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            categoriaServices.delete(id);
            return ResponseEntity.ok().build();
        }
    }

