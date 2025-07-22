package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2PartAApplication implements CommandLineRunner {
  @Autowired
  CustomerService customerService;

  public static void main(String[] args) {
    SpringApplication.run(Lab2PartAApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    customerService.addCustomer("Frank Brown", "fbrown@acme.com", "Main street 5", "Chicago", "60613");
  }
}
