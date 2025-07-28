package app.requiresnew.service;

import app.requiresnew.domain.Account;
import app.requiresnew.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void createAccount(int accountNumber, String accountType, String customerName) {
        try {
            Account account = new Account(accountNumber, accountType);
            accountRepository.save(account);
            System.out.println("---------------- save " + accountNumber);
            customerService.createCustomer(customerName);
        } catch (Exception e) {
            System.out.println("---------------- Exception " + e.getMessage());
        }
    }
}
