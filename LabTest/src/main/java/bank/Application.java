package bank;

import java.sql.Date;
import java.util.Collection;

import bank.dao.PassengerDAO;
import bank.domain.AccountEntry;
import bank.domain.Flight;
import bank.domain.Passenger;
import bank.service.IAccountService;
import bank.service.dto.AccountDTO;
import bank.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  IAccountService accountService;

  @Autowired
  PassengerDAO passengerDAO;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) {
    // create 2 accounts;
//    accountService.createAccount(1263862, "Frank Brown");
    testC();


  }
  public void testC() {
    Passenger passenger = new Passenger("Alice");

    Flight flight1 = new Flight("VN123", "Boston", "New York", Date.valueOf("2025-05-15"));
    Flight flight2 = new Flight("US345", "New York", "London", Date.valueOf("2025-05-20"));

    passenger.addFlight(flight1);
    passenger.addFlight(flight2);

    passengerDAO.save(passenger);
  }
}


