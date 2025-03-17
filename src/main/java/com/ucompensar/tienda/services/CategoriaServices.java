package com.ucompensar.tienda.services;

import com.ucompensar.tienda.controller.exception.NotFoundException;
import com.ucompensar.tienda.persistence.entities.Categoria;
import com.ucompensar.tienda.persistence.mapper.CategoriaMapper;
import com.ucompensar.tienda.persistence.repository.CategoriaDao;
import com.ucompensar.tienda.services.dto.CategoriaDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServices {
    private final CategoriaDao categoriaDao;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaDto> findAll() {
        List<Categoria> marcas = categoriaDao.findAll();
        return categoriaMapper.toCategoriaDto(marcas);
    }

    public CategoriaDto findById(Long id) {
        Categoria categoria = categoriaDao.findById(id).orElseThrow(() -> new NotFoundException(String.format("Categoria %s no se encontro", id)));
        return categoriaMapper.toCategoriaDto(categoria);
    }

    public CategoriaDto create(@Valid CategoriaDto marcaDto) {
        Categoria categoria = categoriaMapper.toCategoria(marcaDto);
        categoria = categoriaDao.save(categoria);
        return categoriaMapper.toCategoriaDto(categoria);
    }

    public CategoriaDto update(Long id, @Valid CategoriaDto marcaDto) {
        Categoria marca = categoriaDao.findById(id).orElseThrow(() -> new NotFoundException(String.format("Categoria %s no se encontro", id)));
        marca.setName(marcaDto.getName());
        marca = categoriaDao.save(marca);
        return categoriaMapper.toCategoriaDto(marca);
    }

    public void delete(Long id) {
        categoriaDao.findById(id).ifPresent(categoriaDao::delete);
    }
}
