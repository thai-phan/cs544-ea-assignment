package app.requiresnew.service;
import app.requiresnew.domain.CustomerRN;
import app.requiresnew.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createCustomer(String name){
        CustomerRN customerRN = new CustomerRN(name);
        if (name.equals("Bob")) throw new RuntimeException("Cannot save Bob");
        customerRepository.save(customerRN);

    }
}
