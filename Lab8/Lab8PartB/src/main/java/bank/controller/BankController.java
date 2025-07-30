package bank.controller;

import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
  @Autowired
  private IAccountService accountService;


  @PostMapping("/accounts/{accountNumber}/deposit")
  public ResponseEntity<String> deposit(@PathVariable long accountNumber, @RequestBody double amount) {
    accountService.deposit(accountNumber, amount);
    return ResponseEntity.ok("Deposit successful");

  }

  @PostMapping("/accounts/{accountNumber}/withdraw")
  public ResponseEntity<String> withdraw(@PathVariable long accountNumber, @RequestBody double amount) {
    try {
      accountService.withdraw(accountNumber, amount);
      return ResponseEntity.ok("Withdrawal successful");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Withdrawal failed: " + e.getMessage());
    }

  }
}
