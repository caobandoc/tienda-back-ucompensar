package com.ucompensar.tienda.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//ignorar la respuesta del json si hay campos nulos
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {
    private Long id;
    private String name;
    private String lastname;
    private String username;
}
