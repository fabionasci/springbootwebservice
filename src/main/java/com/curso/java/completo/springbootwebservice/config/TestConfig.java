package com.curso.java.completo.springbootwebservice.config;

import com.curso.java.completo.springbootwebservice.entities.User;
import com.curso.java.completo.springbootwebservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //@Autowired
    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Lógica para popular o banco de dados com dados de teste

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Jeff Rose", "jrose@gmail.com", "966666666", "123456");
        User u4 = new User(null, "Bob Red", "bobr@gmail.com", "955555555", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
    }
}
