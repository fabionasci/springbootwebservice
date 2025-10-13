package com.curso.java.completo.springbootwebservice.controllers;

import com.curso.java.completo.springbootwebservice.entities.Product;
import com.curso.java.completo.springbootwebservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Set<Product>> findAll() {
        Set<Product> products = productService.findAll();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
    }
}
