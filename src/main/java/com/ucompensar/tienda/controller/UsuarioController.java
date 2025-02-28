package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.dto.UsuarioPostDto;
import com.ucompensar.tienda.dto.UsuarioDto;
import com.ucompensar.tienda.dto.mapper.UsuarioMapper;
import com.ucompensar.tienda.exception.PersonalException;
import com.ucompensar.tienda.persistence.entities.Usuario;
import com.ucompensar.tienda.services.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//@RequiredArgsConstructor
public class UsuarioController {
    // Forma 1
    // Inyectar el servicio de usuarios, pero es una mala forma de inyectar dependencias
    // @Autowired
    // private UsuarioServices usuarioServices;

    // Forma 2
    // Inyectar el servicio de usuarios a través del constructor
    private final UsuarioServices usuarioServices;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioController(UsuarioServices usuarioServices, UsuarioMapper usuarioMapper) {
        this.usuarioServices = usuarioServices;
        this.usuarioMapper = usuarioMapper;
    }

    // Forma 3
    // Inyectar el servicio con final y la anotacion de lombok @RequiredArgsConstructor
    // private final UsuarioServices usuarioServices;

    // GET todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        List<UsuarioDto> response = usuarioMapper.toUsuariosDto(usuarioServices.getAll());
        return ResponseEntity.ok(response);
    }

    // GET usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable("id") Long id) {
        UsuarioDto response = usuarioMapper.toUsuarioDto(usuarioServices.getById(id));
        return ResponseEntity.ok(response);

    }

    // POST crear usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@Valid @RequestBody UsuarioPostDto usuario) {
        Usuario usuarioEntity = usuarioMapper.toUsuario(usuario);
        UsuarioDto response = usuarioMapper.toUsuarioDto(usuarioServices.create(usuarioEntity));
        return ResponseEntity.ok(response);
    }

    // PUT actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsuarioDto usuario) {
        Usuario usuarioEntity = usuarioMapper.toUsuario(usuario);
        UsuarioDto response = usuarioMapper.toUsuarioDto(usuarioServices.update(id, usuarioEntity));
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
