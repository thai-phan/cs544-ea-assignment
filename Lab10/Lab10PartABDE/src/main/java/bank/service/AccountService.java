package bank.service;

import java.util.Collection;
import java.util.Date;

import bank.dao.AccountRepository;
import bank.domain.Account;
import bank.domain.Customer;
import bank.logging.BankLogger;
import bank.service.adapter.AccountAdapter;
import bank.service.adapter.CustomerAdapter;
import bank.jms.IJMSSender;
import bank.logging.ILogger;
import bank.service.dto.AccountDTO;
import bank.service.dto.CustomerDTO;
import bank.service.event.AccountEvent;
import bank.service.event.TraceRecordEvent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

  @Autowired
  private ApplicationEventPublisher publisher;


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

  public AccountDTO getAccount(long accountNumber) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    return AccountAdapter.getDTOFromAccount(account);
  }

  public Collection<AccountDTO> getAllAccounts() {
    return AccountAdapter.getDTOsFromAccounts(accountRepository.findAll());
  }

  public void deposit(long accountNumber, double amount) {

    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    account.deposit(amount);
    accountRepository.save(account);
    logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    if (amount > 10000) {
      jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
    }
    publisher.publishEvent(new AccountEvent("Account deposit"));
    publisher.publishEvent(new TraceRecordEvent(new Date(), accountNumber, "deposit", amount));
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
    publisher.publishEvent(new AccountEvent("Account depositEuros"));
    publisher.publishEvent(new TraceRecordEvent(new Date(), accountNumber, "depositEuros", amount));
  }


  public boolean isWithdrawPossible(long accountNumber, double amount, String currency) {
    if (currency.equals("EUR")) {
      amount = currencyConverter.euroToDollars(amount);
    }
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    return !(account.getBalance() < amount);
  }

  public void withdraw(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    account.withdraw(amount);
    accountRepository.save(account);
    logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    publisher.publishEvent(new AccountEvent("Account withdraw"));
    publisher.publishEvent(new TraceRecordEvent(new Date(), accountNumber, "withdraw", amount));

  }

  public void withdrawEuros(long accountNumber, double amount) {
    Account account = accountRepository.getAccountByAccountNumber(accountNumber);
    double amountDollars = currencyConverter.euroToDollars(amount);
    account.withdraw(amountDollars);
    accountRepository.save(account);
    logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    publisher.publishEvent(new AccountEvent("Account withdrawEuros"));
    publisher.publishEvent(new TraceRecordEvent(new Date(), accountNumber, "withdrawEuros", amount));
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
    publisher.publishEvent(new AccountEvent("Account transferFunds"));
    publisher.publishEvent(new TraceRecordEvent(new Date(), fromAccountNumber, "send transferFunds", amount));
    publisher.publishEvent(new TraceRecordEvent(new Date(), toAccountNumber, "receive transferFunds", amount));
  }
}
