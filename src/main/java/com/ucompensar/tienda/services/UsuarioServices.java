package com.ucompensar.tienda.services;

import com.ucompensar.tienda.dto.UsuarioDto;
import com.ucompensar.tienda.dto.UsuarioPostDto;
import com.ucompensar.tienda.dto.mapper.UsuarioMapper;
import com.ucompensar.tienda.exception.UserNotFoundException;
import com.ucompensar.tienda.exception.UsernameAlreadyExistsException;
import com.ucompensar.tienda.persistence.entities.Usuario;
import com.ucompensar.tienda.persistence.repository.UsuarioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServices {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDto> getAll() {
        return usuarioMapper.toUsuariosDto(usuarioDao.findAll());
    }

    public UsuarioDto getDtoById(Long id) {
        return usuarioMapper.toUsuarioDto(getById(id));
    }

    public Optional<Usuario> getById(Long id) {
        return usuarioDao.findById(id);
    }

    public UsuarioDto create(UsuarioPostDto usuario) {
        Optional<Usuario> usuarioExist = usuarioDao.findByUsername(usuario.getUsername());
        if (usuarioExist.isPresent()) {
            throw new UsernameAlreadyExistsException("El username ya existe");
        }
        Usuario usuarioEntity = usuarioMapper.toUsuario(usuario);
        return usuarioMapper.toUsuarioDto(usuarioDao.save(usuarioEntity));
    }

    public UsuarioDto update(Long id, UsuarioDto usuario) {
        Usuario usuarioUpdate = getById(id).orElse(null);
        if (usuarioUpdate == null) {
            throw new UserNotFoundException("Usuario no encontrado");
        }
        usuarioUpdate.setName(usuario.getName());
        usuarioUpdate.setLastname(usuario.getLastname());
        usuarioUpdate.setUsername(usuario.getUsername());

        return usuarioMapper.toUsuarioDto(usuarioDao.save(usuarioUpdate));
    }

    public void delete(Long id) {
        Usuario usuario = getById(id).orElse(null);
        if (usuario == null) {
            throw new UserNotFoundException("Usuario no encontrado");
        }
        usuarioDao.delete(usuario);
    }
}
