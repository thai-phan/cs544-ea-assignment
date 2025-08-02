package bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class AppLab9PartD implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(AppLab9PartD.class, args);
  }

  public void run(String... args) throws Exception {
    System.out.println("Bank Receiver is running and waiting for messages");
  }
}


