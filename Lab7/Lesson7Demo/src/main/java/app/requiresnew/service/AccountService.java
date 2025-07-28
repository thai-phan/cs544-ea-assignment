package app.requiresnew.service;

import app.requiresnew.domain.AccountRN;
import app.requiresnew.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            AccountRN accountRN = new AccountRN(accountNumber, accountType);
            accountRepository.save(accountRN);
            System.out.println("---------------- save " + accountNumber);
            customerService.createCustomer(customerName);
        } catch (Exception e) {
            System.out.println("---------------- Exception " + e.getMessage());
        }
    }
}
