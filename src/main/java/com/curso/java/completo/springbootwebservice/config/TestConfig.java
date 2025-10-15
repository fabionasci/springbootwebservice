package com.curso.java.completo.springbootwebservice.config;

import com.curso.java.completo.springbootwebservice.entities.*;
import com.curso.java.completo.springbootwebservice.enums.OrderStatus;
import com.curso.java.completo.springbootwebservice.repositories.*;
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

    private final OrderItemRepository orderItemRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
                      CategoryRepository categoryRepository, ProductRepository productRepository,
                      OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Lógica para popular o banco de dados com dados de teste

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

        // Associando produtos às categorias
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

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

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        OrderItem oi5 = new OrderItem(o4, p5, 3, p5.getPrice());
        OrderItem oi6 = new OrderItem(o5, p2, 1, p2.getPrice());
        OrderItem oi7 = new OrderItem(o6, p4, 2, p4.getPrice());
        OrderItem oi8 = new OrderItem(o6, p1, 1, p1.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8));

        Payment pay1 = new Payment(null, java.time.Instant.parse("2023-06-20T21:53:07Z"));
        o1.setPayment(pay1);
        Payment pay2 = new Payment(null, java.time.Instant.parse("2023-08-24T14:30:45Z"));
        o5.setPayment(pay2);

        orderRepository.saveAll(Arrays.asList(o1, o5));
    }
}
