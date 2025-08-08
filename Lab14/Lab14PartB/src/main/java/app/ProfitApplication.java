package app;

import app.ProfitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.Month;

@SpringBootApplication
public class ProfitApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProfitApplication.class, args);
  }

  @Bean
  CommandLineRunner seedData(ProfitRepository repo) {
    return args -> {
      repo.save(new Profit(null, Month.JANUARY, new BigDecimal("12000.50")));
      repo.save(new Profit(null, Month.FEBRUARY, new BigDecimal("15000.00")));
      repo.save(new Profit(null, Month.MARCH, new BigDecimal("9800.75")));
      repo.save(new Profit(null, Month.APRIL, new BigDecimal("20000.00")));
    };
  }
}
