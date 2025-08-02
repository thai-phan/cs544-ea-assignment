package bank.controller;

import bank.service.IAccountService;
import bank.service.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")

public class BankController {
  @Autowired
  private IAccountService accountService;

  @PostMapping("/createAccount")
  public ResponseEntity<?> createAccount(@RequestParam(value = "accountNumber") long accountNumber,
                                         @RequestParam(value = "customerName") String customerName) {
    AccountDTO accountDto = accountService.createAccount(accountNumber, customerName);
    return new ResponseEntity<>(accountDto, HttpStatus.OK);
  }

  @PostMapping("/account")
  public ResponseEntity<?> deposit(@RequestBody AccountCommand accountCommand) {
    long accountNumber = accountCommand.getAccountNumber();
    long toAccountNumber = accountCommand.getToAccountNumber();
    double amount = accountCommand.getAmount();
    String operation = accountCommand.getOperation();
    String description = accountCommand.getDescription();

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
      return ResponseEntity.ok("Deposit in Euros successful");
    }
    accountService.deposit(accountNumber, amount);
    return ResponseEntity.ok("Deposit successful");
  }


  @GetMapping("/accounts")
  public ResponseEntity<?> getAllAccounts() {
    Collection<AccountDTO> accountList = accountService.getAllAccounts();
    return new ResponseEntity<>(accountList, HttpStatus.OK);
  }
}
