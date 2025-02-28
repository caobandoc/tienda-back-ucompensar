package com.ucompensar.tienda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
//ignorar la respuesta del json si hay campos nulos
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {
    private Long id;
    private String name;
    private String lastname;
    private String username;
}
