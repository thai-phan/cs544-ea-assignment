package bank.service;

import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BankService {
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private EmailSender emailSender;

  @Autowired
  private TraceRecordRepository traceRecordRepository;


  @Transactional
  public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber) {
    try {
      Account account = new Account(AccountNumber);
      accountRepository.save(account);
      Customer customer = new Customer(customerId, customerName);
      customer.setAccount(account);
      customerRepository.saveCustomer(customer);
      emailSender.sendEmail(emailAddress, "Welcome " + customerName);
      String message = "Customer " + customerName + "created with account " + AccountNumber;
      TraceRecord traceRecord = new TraceRecord(Date.from(java.time.Instant.now()), message);
      traceRecordRepository.save(traceRecord);
    } catch (Exception e) {
      String message = "Could not create customer " + customerName + "created with account " + AccountNumber;
      TraceRecord traceRecord = new TraceRecord(Date.from(java.time.Instant.now()), message);
      traceRecordRepository.save(traceRecord);
      emailSender.sendEmail(emailAddress, "We could not create your account " + customerName);
      throw e; // Optionally rethrow the exception to trigger a rollback
    }
  }
}
