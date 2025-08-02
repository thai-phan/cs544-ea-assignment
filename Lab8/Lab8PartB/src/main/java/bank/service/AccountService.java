package bank.service;

import java.util.Collection;

import bank.dao.AccountRepository;
import bank.domain.Account;
import bank.domain.Customer;
import bank.service.adapter.AccountAdapter;
import bank.service.adapter.CustomerAdapter;
import bank.jms.IJMSSender;
import bank.logging.ILogger;
import bank.service.dto.AccountDTO;
import bank.service.dto.CustomerDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountService implements IAccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private ICurrencyConverter currencyConverter;

  @Autowired
  private IJMSSender jmsSender;

  @Autowired
  private ILogger logger;


  public AccountDTO createAccount(long accountNumber, String customerName) {
    AccountDTO accountDTO = new AccountDTO(accountNumber);
    CustomerDTO customerDTO = new CustomerDTO(customerName);

    Account account = AccountAdapter.getAccountFromDTO(accountDTO);
    Customer customer = CustomerAdapter.getCustomerFromDTO(customerDTO);

    account.setCustomer(customer);

    accountRepository.save(account);
    logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
    return accountDTO;
  }

  public void deposit(long accountNumber, double amount) {

    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    account.deposit(amount);
    accountRepository.save(account);
    logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    if (amount > 10000) {
      jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
    }
  }

  public AccountDTO getAccount(long accountNumber) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    return AccountAdapter.getDTOFromAccount(account);
  }

  public Collection<AccountDTO> getAllAccounts() {
    return AccountAdapter.getDTOsFromAccounts(accountRepository.findAll());
  }

  public boolean isWithdrawPossible(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    return !(account.getBalance() < amount);
  }

  public void withdraw(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);

    account.withdraw(amount);
    accountRepository.save(account);
    logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
  }

  public void depositEuros(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    double amountDollars = currencyConverter.euroToDollars(amount);
    account.deposit(amountDollars);
    accountRepository.save(account);
    logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    if (amountDollars > 10000) {
      jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
    }
  }

  public void withdrawEuros(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    double amountDollars = currencyConverter.euroToDollars(amount);
    account.withdraw(amountDollars);
    accountRepository.save(account);
    logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
  }

  public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
    Account fromAccount = accountRepository.getAccountByAccountNumber(fromAccountNumber);
    Account toAccount = accountRepository.getAccountByAccountNumber(toAccountNumber);
    fromAccount.transferFunds(toAccount, amount, description);
    accountRepository.save(fromAccount);
    accountRepository.save(toAccount);
    logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
    if (amount > 10000) {
      jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount + " to account with accountNumber= " + toAccount);
    }
  }
}
