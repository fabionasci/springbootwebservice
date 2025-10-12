package com.curso.java.completo.springbootwebservice.repositories;

import com.curso.java.completo.springbootwebservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
