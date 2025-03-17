package com.ucompensar.tienda.persistence.repository;

import com.ucompensar.tienda.persistence.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
}
