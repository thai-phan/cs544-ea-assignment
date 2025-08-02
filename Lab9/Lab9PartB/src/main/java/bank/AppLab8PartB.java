package bank;

import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class AppLab8PartB {

  @Autowired
  IAccountService accountService;

  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartB.class, args);
  }
}


