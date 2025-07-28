package app.required.service;

import app.required.domain.Customer;
import app.required.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  @Transactional
  public void createCustomer(String name) {
    Customer customer = new Customer(name);
    if (name.equals("Bob")) throw new RuntimeException();
    customerRepository.save(customer);

  }
}
