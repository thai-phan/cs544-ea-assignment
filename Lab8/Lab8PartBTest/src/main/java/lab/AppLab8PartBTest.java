package lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


@SpringBootApplication
public class AppLab8PartBTest implements CommandLineRunner {
  RestClient restClient = RestClient.builder()
      .baseUrl("http://localhost:8080")
      .build();

  public static void main(String[] args) {
    SpringApplication.run(AppLab8PartBTest.class, args);
  }

  @Override
  public void run(String... args) throws Exception {


//    Object create = restClient.post()
//          .uri("/accounts/createAccount?accountNumber=123456789&customerName=John%20Doe")
//        .retrieve()
//        .body(Object.class);
//    System.out.println(create);

    AccountCreation account1 = new AccountCreation(123456789, "John Doe");
    createAccount(account1);
    AccountCreation account2 = new AccountCreation(987654321, "Jane Smith");
    createAccount(account2);
    AccountCommand command1 = new AccountCommand(123456789, 500.0, "deposit");
    sendAccountCommand(command1);
    AccountCommand command2 = new AccountCommand(123456789, 200.0, "withdraw");
    sendAccountCommand(command2);
    AccountCommand command3 = new AccountCommand(123456789, 100.0, "transferFunds", 987654321, "Payment for services");
    sendAccountCommand(command3);
//
//    AccountCommand command = new AccountCommand(
//        123456789,
//        100000.00,
//        "deposit"
//    );
//    String commandRes = restClient
//        .post()
//        .uri("/accounts/account")
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(command)
//        .retrieve()
//        .body(String.class);
//    System.out.println(commandRes);

  }

  public void createAccount(AccountCreation account) {
    Object create = restClient.post()
        .uri("/accounts/create-account")
        .body(account)
        .retrieve()
        .body(Object.class);
    System.out.println(create);
  }

  public void sendAccountCommand(AccountCommand command) {
    String response = restClient.post()
        .uri("/accounts/account")
        .contentType(MediaType.APPLICATION_JSON)
        .body(command)
        .retrieve()
        .body(String.class);
    System.out.println(response);
  }
}


