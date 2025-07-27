package bank.service.adapter;

import bank.domain.Customer;
import bank.service.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {

  public static Customer getCustomerFromDTO(CustomerDTO customerDTO) {
    return new Customer(customerDTO.name());
  }

  public static CustomerDTO getDTOFromCustomer(Customer customer) {
    return new CustomerDTO(customer.getName());
  }

  public static List<CustomerDTO> getDTOsFromCustomers(List<Customer> customers) {
    List<CustomerDTO> customerDTOS = new ArrayList<>();
    for (Customer customer : customers) {
      customerDTOS.add(getDTOFromCustomer(customer));
    }
    return customerDTOS;
  }
}