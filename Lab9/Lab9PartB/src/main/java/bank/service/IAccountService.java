package bank.service;

import java.util.Collection;

import bank.service.dto.AccountDTO;


public interface IAccountService {
  AccountDTO createAccount(long accountNumber, String customerName);

  AccountDTO getAccount(long accountNumber);

  Collection<AccountDTO> getAllAccounts();

  void deposit(long accountNumber, double amount);

  boolean isWithdrawPossible(long accountNumber, double amount, String currency);

  void withdraw(long accountNumber, double amount);

  void depositEuros(long accountNumber, double amount);

  void withdrawEuros(long accountNumber, double amount);

  void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
