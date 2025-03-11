package com.ucompensar.tienda.persistence.repository;

import com.ucompensar.tienda.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {
    Optional<Producto> findByName(String name);
}
