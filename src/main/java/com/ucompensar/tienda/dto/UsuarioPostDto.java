package com.ucompensar.tienda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioPostDto extends UsuarioDto {
    @NotBlank(message = "El campo username es obligatorio")
    private String username;
    @NotBlank(message = "El campo password es obligatorio")
    @Size(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;
}
