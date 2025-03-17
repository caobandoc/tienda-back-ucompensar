package com.ucompensar.tienda.persistence.mapper;

import com.ucompensar.tienda.persistence.entities.Marca;
import com.ucompensar.tienda.services.dto.MarcaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcaMapper {
    public List<MarcaDto> toMarcasDto(List<Marca> marcas) {
        return marcas.stream().map(this::toMarcaDto).toList();
    }

    public MarcaDto toMarcaDto(Marca marca) {
        return MarcaDto.builder()
                .id(marca.getId())
                .name(marca.getName())
                .build();
    }

    public Marca toMarca(MarcaDto marcaDto) {
        return Marca.builder()
                .name(marcaDto.getName())
                .build();
    }
}
