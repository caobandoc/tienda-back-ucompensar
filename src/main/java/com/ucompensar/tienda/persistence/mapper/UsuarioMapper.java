package com.ucompensar.tienda.persistence.mapper;

import com.ucompensar.tienda.services.dto.UsuarioDto;
import com.ucompensar.tienda.services.dto.UsuarioPostDto;
import com.ucompensar.tienda.persistence.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDto toUsuarioDto(Optional<Usuario> usuario) {
        return usuario.map(value -> UsuarioDto.builder()
                .id(value.getId())
                .name(value.getName())
                .lastname(value.getLastname())
                .username(value.getUsername())
                .build()).orElse(null);
    }

    public UsuarioDto toUsuarioDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .name(usuario.getName())
                .lastname(usuario.getLastname())
                .username(usuario.getUsername())
                .build();
    }

    public Usuario toUsuario(UsuarioPostDto usuario) {
        return Usuario.builder()
                .name(usuario.getName())
                .lastname(usuario.getLastname())
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .build();
    }

    public Usuario toUsuario(UsuarioDto usuario) {
        return Usuario.builder()
                .name(usuario.getName())
                .lastname(usuario.getLastname())
                .username(usuario.getUsername())
                .build();
    }

    public List<UsuarioDto> toUsuariosDto(List<Usuario> all) {
        return all.stream().map(this::toUsuarioDto).collect(Collectors.toList());
    }
}
