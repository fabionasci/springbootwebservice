package com.curso.java.completo.springbootwebservice.controllers;


import com.curso.java.completo.springbootwebservice.dtos.UserDto;
import com.curso.java.completo.springbootwebservice.entities.User;
import com.curso.java.completo.springbootwebservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> create(@RequestBody UserDto userDto) {
        userService.create(userDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
