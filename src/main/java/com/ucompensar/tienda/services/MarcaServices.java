package com.ucompensar.tienda.services;

import com.ucompensar.tienda.controller.exception.NotFoundException;
import com.ucompensar.tienda.persistence.entities.Marca;
import com.ucompensar.tienda.persistence.mapper.MarcaMapper;
import com.ucompensar.tienda.persistence.repository.MarcaDao;
import com.ucompensar.tienda.services.dto.MarcaDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServices {
    private final MarcaDao marcaDao;
    private final MarcaMapper marcaMapper;

    public List<MarcaDto> findAll() {
        List<Marca> marcas = marcaDao.findAll();
        return marcaMapper.toMarcasDto(marcas);
    }

    public MarcaDto findById(Long id) {
        Marca marca = marcaDao.findById(id).orElseThrow(() -> new NotFoundException(String.format("Marca %s no se encontro", id)));
        return marcaMapper.toMarcaDto(marca);
    }

    public MarcaDto create(@Valid MarcaDto marcaDto) {
        Marca marca = marcaMapper.toMarca(marcaDto);
        marca = marcaDao.save(marca);
        return marcaMapper.toMarcaDto(marca);
    }

    public MarcaDto update(Long id, @Valid MarcaDto marcaDto) {
        Marca marca = marcaDao.findById(id).orElseThrow(() -> new NotFoundException(String.format("Marca %s no se encontro", id)));
        marca.setName(marcaDto.getName());
        marca = marcaDao.save(marca);
        return marcaMapper.toMarcaDto(marca);
    }

    public void delete(Long id) {
        marcaDao.findById(id).ifPresent(marcaDao::delete);
    }
}
