package bank;

import java.sql.Date;

import bank.dao.AccountRepository;
import bank.dao.PassengerRepository;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Flight;
import bank.domain.Passenger;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  IAccountService accountService;

  @Autowired
  PassengerRepository passengerRepository;

  @Autowired
  AccountRepository accountRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) {
    // create 2 accounts;
//    accountService.createAccount(1263862, "Frank Brown");

    testAccount();

//    testPassenger();

  }

  public void testAccount() {
    Account account = new Account(1234567);

    AccountEntry entry1 = new AccountEntry(Date.valueOf("2022-05-12"), 11, "deposit", "aaaa");
    AccountEntry entry2 = new AccountEntry(Date.valueOf("2022-05-20"), 11, "deposit", "bbbb");
    account.addEntry(entry1);
    account.addEntry(entry2);

    accountRepository.save(account);
  }

  public void testPassenger() {
    Passenger passenger = new Passenger("Alice");

    Flight flight1 = new Flight("VN123", "Boston", "New York", Date.valueOf("2025-05-15"));
    Flight flight2 = new Flight("US345", "New York", "London", Date.valueOf("2025-05-20"));
    passenger.addFlight(flight1);
    passenger.addFlight(flight2);

    passengerRepository.save(passenger);
  }
}


