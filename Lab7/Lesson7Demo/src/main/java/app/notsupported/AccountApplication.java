package app.notsupported;

import app.notsupported.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner{
	@Autowired
	AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.createAccount(22, "Saving", "Welcome");
		accountService.createAccount(33, "Checking", "Hello");
	}
}

