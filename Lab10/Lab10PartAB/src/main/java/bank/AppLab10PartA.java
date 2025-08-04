package bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
//@EnableKafka
@EnableScheduling
public class AppLab10PartA implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(AppLab10PartA.class, args);
  }

  public void run(String... args) throws Exception {
    System.out.println("Bank Receiver is running and waiting for messages");
  }
}


