package com.curso.java.completo.springbootwebservice.services;

import com.curso.java.completo.springbootwebservice.entities.Product;
import com.curso.java.completo.springbootwebservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<Product> findAll() {
        Set<Product> products = new HashSet<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElse(null);
    }
}
