package com.curso.java.completo.springbootwebservice.repositories;

import com.curso.java.completo.springbootwebservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
