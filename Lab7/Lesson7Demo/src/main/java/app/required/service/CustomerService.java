package app.required.service;

import app.required.domain.CustomerR;
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
    CustomerR customerR = new CustomerR(name);
    if (name.equals("Bob")) throw new RuntimeException();
    customerRepository.save(customerR);

  }
}
