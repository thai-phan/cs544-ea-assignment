package app;

import app.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductQaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductQaApplication.class, args);
  }

  @Bean
  CommandLineRunner seedDatabase(ProductRepository repo) {
    return args -> {
      repo.save(new Product(null, "Smartphone X1", "A modern smartphone with 6.5\" screen, 128GB storage", new BigDecimal("699.99"), 25, 4.5));
      repo.save(new Product(null, "Wireless Headphones Pro", "Noise-cancelling over-ear headphones", new BigDecimal("199.99"), 40, 4.7));
      repo.save(new Product(null, "Gaming Laptop Z", "Powerful gaming laptop: RTX graphics, 16GB RAM", new BigDecimal("1499.00"), 8, 4.3));
      repo.save(new Product(null, "USB-C Charger 30W", "Compact 30W fast charger", new BigDecimal("24.99"), 120, 4.1));
      repo.save(new Product(null, "Smartwatch Mini", "Fitness tracking smartwatch, 7-day battery", new BigDecimal("129.99"), 60, 4.2));
    };
  }
}
