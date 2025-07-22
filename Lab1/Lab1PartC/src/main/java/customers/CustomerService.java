package customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService implements ICustomerService {
  private ICustomerDAO customerDAO;
  private IEmailSender emailSender;

  public void addCustomer(String name, String email, String street, String city, String zip) {
    Customer customer = new Customer(name, email);
    Address address = new Address(street, city, zip);
    customer.setAddress(address);
    customerDAO.save(customer);
    emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
  }

  @Autowired
  public void setCustomerDAO(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  @Autowired
  public void setEmailSender(EmailSender emailSender) {
    this.emailSender = emailSender;
  }
}
