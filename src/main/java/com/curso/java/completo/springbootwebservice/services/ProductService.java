package com.curso.java.completo.springbootwebservice.services;

import com.curso.java.completo.springbootwebservice.entities.Order;
import com.curso.java.completo.springbootwebservice.entities.Product;
import com.curso.java.completo.springbootwebservice.repositories.OrderRepository;
import com.curso.java.completo.springbootwebservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElse(null);
    }
}
