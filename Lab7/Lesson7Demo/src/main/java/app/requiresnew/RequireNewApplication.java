package app.requiresnew;

import app.requiresnew.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RequireNewApplication implements CommandLineRunner{
	@Autowired
    AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(RequireNewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.createAccount(22, "Saving", "Frank");
		accountService.createAccount(33, "Checking", "Bob");
	}
}

