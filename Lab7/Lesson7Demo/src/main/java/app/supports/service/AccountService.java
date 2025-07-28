package app.supports.service;

import app.supports.domain.Account;
import app.supports.integration.EmailSender;
import app.supports.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    EmailSender emailSender;
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void createAccount(int accountNumber, String accountType, String email) {
        try {
            Account account = new Account(accountNumber, accountType);
            accountRepository.save(account);
            System.out.println("---------------- save " + accountNumber);
            emailSender.sendEmail(email);
        } catch (Exception e) {
            System.out.println("---------------- Exception " + e.getMessage());
        }
    }
}
