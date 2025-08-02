package lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;



@SpringBootApplication
public class AppLab8PartBTest implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartBTest.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    RestClient restClient = RestClient.builder()
        .baseUrl("http://localhost:8080")
        .build();

    Object create = restClient.post()
          .uri("/accounts/createAccount?accountNumber=123456789&customerName=John%20Doe")
        .retrieve()
        .body(Object.class);
    System.out.println(create);


    AccountCommand command = new AccountCommand(
        123456789,
        100000.00,
        "deposit"
    );
    String commandRes = restClient
        .post()
        .uri("/accounts/account")
        .contentType(MediaType.APPLICATION_JSON)
        .body(command)
        .retrieve()
        .body(String.class);
    System.out.println(commandRes);

  }
}


