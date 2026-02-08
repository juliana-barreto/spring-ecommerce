package com.juliana_barreto.ecommerce;

import com.juliana_barreto.ecommerce.modules.order.Order;
import com.juliana_barreto.ecommerce.modules.order.OrderRepository;
import com.juliana_barreto.ecommerce.modules.order.OrderStatus;
import com.juliana_barreto.ecommerce.modules.category.Category;
import com.juliana_barreto.ecommerce.modules.category.CategoryRepository;
import com.juliana_barreto.ecommerce.modules.user.User;
import com.juliana_barreto.ecommerce.modules.user.UserRepository;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = User.builder()
        .name("Maria Brown")
        .email("maria@gmail.com")
        .phone("988888888")
        .cpf("19999999991")
        .password("123456")
        .build();

    User u2 = User.builder()
        .name("Alex Green")
        .email("alex@gmail.com")
        .phone("977777777")
        .cpf("12345678902")
        .password("123456")
        .build();

    userRepository.saveAll(List.of(u1, u2));

    Order o1 = Order.builder()
        .moment(Instant.parse("2019-06-20T19:53:07Z"))
        .status(OrderStatus.PAID)
        .client(u1)
        .build();

    Order o2 = Order.builder()
        .moment(Instant.parse("2019-07-21T03:42:10Z"))
        .status(OrderStatus.AWAITING_PAYMENT)
        .client(u2)
        .build();

    Order o3 = Order.builder()
        .moment(Instant.parse("2019-07-22T15:21:22Z"))
        .status(OrderStatus.AWAITING_PAYMENT)
        .client(u1)
        .build();

    orderRepository.saveAll(List.of(o1, o2, o3));

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    categoryRepository.saveAll(List.of(cat1, cat2, cat3));
  }
}
