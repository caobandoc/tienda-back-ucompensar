package com.ucompensar.tienda.services;

import com.ucompensar.tienda.controller.exception.LoginException;
import com.ucompensar.tienda.dto.LoginDto;
import com.ucompensar.tienda.dto.LoginResponseDto;
import com.ucompensar.tienda.persistence.entities.Usuario;
import com.ucompensar.tienda.persistence.repository.UsuarioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServices {
    private final UsuarioDao usuarioDao;

    public LoginResponseDto login(LoginDto login) {
        Optional<Usuario> usuarioExist = usuarioDao.findByUsername(login.getUsername());
        if (usuarioExist.isPresent()) {
            Usuario usuario = usuarioExist.get();
            if (usuario.getPassword().equals(login.getPassword())) {
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                loginResponseDto.setToken("token");
                return loginResponseDto;
            } else {
                throw new LoginException("La contraseña es incorrecta");
            }
        } else {
            throw new LoginException("El usuario no existe");
        }
    }
}
