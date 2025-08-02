package bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class AppLab8PartB {

  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartB.class, args);
  }
}


