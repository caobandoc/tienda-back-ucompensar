package com.ucompensar.tienda.services.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ucompensar.tienda.persistence.entities.Categoria;
import com.ucompensar.tienda.persistence.entities.Marca;
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
public class ProductoDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Integer quantity;

    private Categoria category;
    private Marca brand;
}
