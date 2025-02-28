package com.ucompensar.tienda.dto.mapper;

import com.ucompensar.tienda.dto.UsuarioDto;
import com.ucompensar.tienda.dto.UsuarioPostDto;
import com.ucompensar.tienda.persistence.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

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
