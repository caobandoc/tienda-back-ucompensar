package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.services.MarcaServices;
import com.ucompensar.tienda.services.dto.MarcaDto;
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
@RequestMapping("/marca")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaServices marcaServices;

    @GetMapping
    public ResponseEntity<List<MarcaDto>> findAll() {
        return ResponseEntity.ok(marcaServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(marcaServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<MarcaDto> create(@Valid @RequestBody MarcaDto marcaDto) {
        return ResponseEntity.ok(marcaServices.create(marcaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDto> update(@PathVariable Long id, @Valid @RequestBody MarcaDto marcaDto) {
        return ResponseEntity.ok(marcaServices.update(id, marcaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        marcaServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
