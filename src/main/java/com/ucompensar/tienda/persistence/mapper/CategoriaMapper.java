package com.ucompensar.tienda.persistence.mapper;

import com.ucompensar.tienda.persistence.entities.Categoria;
import com.ucompensar.tienda.services.dto.CategoriaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {
    public List<CategoriaDto> toCategoriaDto(List<Categoria> categorias) {
        return categorias.stream().map(this::toCategoriaDto).toList();
    }

    public CategoriaDto toCategoriaDto(Categoria categoria) {
        return CategoriaDto.builder()
                .id(categoria.getId())
                .name(categoria.getName())
                .build();
    }

    public Categoria toCategoria(CategoriaDto categoriaDto) {
        return Categoria.builder()
                .name(categoriaDto.getName())
                .build();
    }
}
