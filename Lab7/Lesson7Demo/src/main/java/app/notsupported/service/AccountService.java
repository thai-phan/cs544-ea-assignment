package app.notsupported.service;

import app.notsupported.domain.Account;
import app.notsupported.repositories.AccountRepository;
import app.notsupported.integration.EmailSender;
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
        } catch (RuntimeException e) {
            System.out.println("---------------- Exception " + e.getMessage());
        }
    }
}
