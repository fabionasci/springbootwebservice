package com.curso.java.completo.springbootwebservice.repositories;

import com.curso.java.completo.springbootwebservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
