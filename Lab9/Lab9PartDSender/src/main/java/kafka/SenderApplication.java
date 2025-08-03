package kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
  @Autowired
  Sender sender;

  public static void main(String[] args) {
    SpringApplication.run(SenderApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
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
  }

  public void createAccount(AccountCreation accountCreation) throws JsonProcessingException {
    System.out.println("Starting to send a createAccount message");
    ObjectMapper objectMapper = new ObjectMapper();
    String accountAsString = objectMapper.writeValueAsString(accountCreation);
    sender.send("topicBankAccountCreation", accountAsString);
    System.out.println("Message has been sent");
  }

  public void sendAccountCommand(AccountCommand accountDeposit) throws JsonProcessingException {
    System.out.println("Starting to send a command message");
    ObjectMapper objectMapper = new ObjectMapper();
    String accountAsString = objectMapper.writeValueAsString(accountDeposit);
    sender.send("topicBankAccountCommand", accountAsString);
    System.out.println("Command message has been sent");
  }
}
