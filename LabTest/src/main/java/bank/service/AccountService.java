package bank.service;

import java.util.Collection;

import bank.dao.AccountRepository;
import bank.domain.Account;
import bank.service.adapter.AccountAdapter;
import bank.service.dto.AccountDTO;
import bank.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private ICurrencyConverter currencyConverter;



  public AccountDTO createAccount(long accountNumber, String customerName) {
    AccountDTO accountDTO = new AccountDTO(accountNumber);
    CustomerDTO customerDTO = new CustomerDTO(customerName);
//
//    Account account = AccountAdapter.getAccountFromDTO(accountDTO);
//    Customer customer = CustomerAdapter.getCustomerFromDTO(customerDTO);

    Account account = new Account(accountNumber);
    account.deposit(10.00);


    accountRepository.save(account);
    return accountDTO;
  }

  public void deposit(long accountNumber, double amount) {

    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    account.deposit(amount);
    accountRepository.save(account);
  }

  public AccountDTO getAccount(long accountNumber) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    return AccountAdapter.getDTOFromAccount(account);
  }

  public Collection<AccountDTO> getAllAccounts() {
    return AccountAdapter.getDTOsFromAccounts(accountRepository.findAll());
  }

  public void withdraw(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    account.withdraw(amount);
    accountRepository.save(account);
  }

  public void depositEuros(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    double amountDollars = currencyConverter.euroToDollars(amount);
    account.deposit(amountDollars);
    accountRepository.save(account);
  }

  public void withdrawEuros(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    double amountDollars = currencyConverter.euroToDollars(amount);
    account.withdraw(amountDollars);
    accountRepository.save(account);
  }

  public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
    Account fromAccount = accountRepository.getAccountByAccountNumber(fromAccountNumber);
    Account toAccount = accountRepository.getAccountByAccountNumber(toAccountNumber);
    fromAccount.transferFunds(toAccount, amount, description);
    accountRepository.save(fromAccount);
    accountRepository.save(toAccount);
  }
}
