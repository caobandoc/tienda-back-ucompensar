package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.dto.UsuarioDto;
import com.ucompensar.tienda.dto.UsuarioPostDto;
import com.ucompensar.tienda.dto.mapper.UsuarioMapper;
import com.ucompensar.tienda.exception.PersonalException;
import com.ucompensar.tienda.persistence.entities.Usuario;
import com.ucompensar.tienda.services.UsuarioServices;
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
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    // GET todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        List<UsuarioDto> response = usuarioServices.getAll();
        return ResponseEntity.ok(response);
    }

    // GET usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable("id") Long id) {
        UsuarioDto response = usuarioServices.getDtoById(id);
        return ResponseEntity.ok(response);

    }

    // POST crear usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody UsuarioPostDto usuario) {
        UsuarioDto response = usuarioServices.create(usuario);
        return ResponseEntity.ok(response);
    }

    // PUT actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsuarioDto usuario) {
        UsuarioDto response =usuarioServices.update(id, usuario);
        return ResponseEntity.ok(response);
    }

    // DELETE borrar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id) {
        usuarioServices.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exception")
    public ResponseEntity<Void> exception() {
        throw new PersonalException("Probando excepciones");
    }
}
