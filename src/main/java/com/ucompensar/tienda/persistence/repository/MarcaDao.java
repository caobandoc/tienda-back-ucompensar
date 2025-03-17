package com.ucompensar.tienda.persistence.repository;

import com.ucompensar.tienda.persistence.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaDao extends JpaRepository<Marca, Long> {
}
