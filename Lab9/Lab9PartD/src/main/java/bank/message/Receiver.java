package bank.message;


import bank.service.IAccountService;
import bank.service.dto.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class Receiver {
  @Autowired
  private IAccountService accountService;

  @KafkaListener(topics = {"topicBankAccountCommand"}, groupId = "bankGroup")
  public void receiveAccountCommand(@Payload String accountAsString) {

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      AccountReceiver accountReceiver = objectMapper.readValue(accountAsString, AccountReceiver.class);

      long accountNumber = accountReceiver.getAccountNumber();
      long toAccountNumber = accountReceiver.getToAccountNumber();
      double amount = accountReceiver.getAmount();
      String operation = accountReceiver.getOperation();
      String description = accountReceiver.getDescription();

      if (operation.equals("deposit")) {
        accountService.deposit(accountNumber, amount);
      }
      if (operation.equals("depositEuros")) {
        accountService.depositEuros(accountNumber, amount);
      }
      if (operation.equals("withdraw")) {
        if (!accountService.isWithdrawPossible(accountNumber, amount, "USD")) {
          throw new RuntimeException("Insufficient funds for withdrawal");
        }
        accountService.withdraw(accountNumber, amount);
      }
      if (operation.equals("withdrawEuros")) {
        if (!accountService.isWithdrawPossible(accountNumber, amount, "EUR")) {
          throw new RuntimeException("Insufficient funds for withdrawal");
        }
        accountService.withdrawEuros(accountNumber, amount);
      }
      if (operation.equals("transferFunds")) {
        accountService.transferFunds(accountNumber, toAccountNumber, amount, description);
      }
      if (operation.equals("depositEuros")) {
        accountService.depositEuros(accountNumber, amount);
      }
      accountService.deposit(accountNumber, amount);
    } catch (IOException e) {
      System.out.println("JMS receiver: Cannot convert : " + accountAsString + " to a AccountReceiver object");
    }
  }

  @KafkaListener(topics = {"topicBankAccountCreation"}, groupId = "bankGroup")
  public void receiveAccountCreation(@Payload String accountAsString) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      AccountCreation accountCreation = objectMapper.readValue(accountAsString, AccountCreation.class);
      long accountNumber = accountCreation.getAccountNumber();
      String customerName = accountCreation.getCustomerName();
      AccountDTO accountDto = accountService.createAccount(accountNumber, customerName);
    } catch (IOException e) {
      System.out.println("JMS receiver: Cannot convert : " + accountAsString + " to a AccountReceiver object");
    }
  }

}