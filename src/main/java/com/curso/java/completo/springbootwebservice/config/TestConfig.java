package com.curso.java.completo.springbootwebservice.config;

import com.curso.java.completo.springbootwebservice.entities.Category;
import com.curso.java.completo.springbootwebservice.entities.Order;
import com.curso.java.completo.springbootwebservice.entities.Product;
import com.curso.java.completo.springbootwebservice.entities.User;
import com.curso.java.completo.springbootwebservice.enums.OrderStatus;
import com.curso.java.completo.springbootwebservice.repositories.CategoryRepository;
import com.curso.java.completo.springbootwebservice.repositories.OrderRepository;
import com.curso.java.completo.springbootwebservice.repositories.ProductRepository;
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

    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Lógica para popular o banco de dados com dados de teste

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Jeff Rose", "jrose@gmail.com", "966666666", "123456");
        User u4 = new User(null, "Bob Red", "bobr@gmail.com", "955555555", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        Order o1 = new Order(null, java.time.Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, java.time.Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, java.time.Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o4 = new Order(null, java.time.Instant.parse("2023-08-23T10:15:30Z"), OrderStatus.CANCELED, u4);
        Order o5 = new Order(null, java.time.Instant.parse("2023-08-24T12:30:45Z"), OrderStatus.PAID, u3);
        Order o6 = new Order(null, java.time.Instant.parse("2023-08-25T14:45:50Z"), OrderStatus.SHIPPED, u2);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
