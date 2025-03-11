package com.ucompensar.tienda.persistence.mapper;

import com.ucompensar.tienda.persistence.entities.Producto;
import com.ucompensar.tienda.services.dto.ProductoDto;
import com.ucompensar.tienda.services.dto.ProductoPostDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {
    public ProductoDto toProductoDto(Optional<Producto> producto) {
        return producto.map(value -> ProductoDto.builder()
                .id(value.getId())
                .name(value.getName())
                .price(value.getPrice())
                .description(value.getDescription())
                .imageUrl(value.getImageUrl())
                .quantity(value.getQuantity())
                .categoria(value.getCategoria())
                .marca(value.getMarca())
                .build()).orElse(null);
    }

    public ProductoDto toProductoDto(Producto producto) {
        return ProductoDto.builder()
                .id(producto.getId())
                .name(producto.getName())
                .price(producto.getPrice())
                .description(producto.getDescription())
                .imageUrl(producto.getImageUrl())
                .quantity(producto.getQuantity())
                .categoria(producto.getCategoria())
                .marca(producto.getMarca())
                .build();
    }

    public Producto toProducto(ProductoPostDto producto) {
        return Producto.builder()
                .name(producto.getName())
                .price(producto.getPrice())
                .description(producto.getDescription())
                .imageUrl(producto.getImageUrl())
                .quantity(producto.getQuantity())
                .categoria(producto.getCategoria())
                .marca(producto.getMarca())
                .build();
    }

    public Producto toProducto(ProductoDto producto){
        return Producto.builder()
                .name(producto.getName())
                .price(producto.getPrice())
                .description(producto.getDescription())
                .imageUrl(producto.getImageUrl())
                .quantity(producto.getQuantity())
                .categoria(producto.getCategoria())
                .marca(producto.getMarca())
                .build();
    }

    public List<ProductoDto> toProductosDto(List<Producto> all) {
        return all.stream().map(this::toProductoDto).collect(Collectors.toList());
    }
}
