package com.curso.java.completo.springbootwebservice.repositories;

import com.curso.java.completo.springbootwebservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
