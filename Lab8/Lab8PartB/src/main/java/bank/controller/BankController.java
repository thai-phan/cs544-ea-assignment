package bank.controller;

import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")

public class BankController {
  @Autowired
  private IAccountService accountService;

  @GetMapping("/hi")
  public ResponseEntity<?> getAccount() {
    return ResponseEntity.ok("Deposit successful");

  }

  @PostMapping("/deposit")
  public ResponseEntity<String> deposit(@RequestBody long accountNumber, @RequestBody double amount) {
    accountService.deposit(accountNumber, amount);
    return ResponseEntity.ok("Deposit successful");

  }

  @PostMapping("/{account}/withdraw")
  public ResponseEntity<String> withdraw(@PathVariable("account") long account, @RequestBody double amount ) {
//    long accountNumber = 1263862;
//    double amount = 99999;
    if (!accountService.isWithdrawPossible(account, amount)) {
      throw new RuntimeException("Insufficient funds for withdrawal");

    }
    accountService.withdraw(account, amount);
    return ResponseEntity.ok("Withdrawal successful");
  }
}
