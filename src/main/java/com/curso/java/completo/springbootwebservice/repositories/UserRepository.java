package com.curso.java.completo.springbootwebservice.repositories;

import com.curso.java.completo.springbootwebservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
