package bank.schedule;

import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BankStatementPrinter {

  @Autowired
  AccountService accountService;

  @Scheduled(fixedRate = 10000)
  public void printer() {
    System.out.println(accountService.getAllAccounts());
  }
}
