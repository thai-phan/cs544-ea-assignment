package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
public class AccountTest {
  @Autowired
  AccountRepository accountRepository;

  @Autowired
  TestEntityManager entityManager;

  @Test
  public void testFindByAccountHolder() {
    Account account = new Account("77777", 50.0, "John Doe");
    entityManager.persist(account);
    entityManager.flush();

    Account foundAccount = accountRepository.findByAccountHolder("John Doe");
    assertThat(foundAccount.getAccountNumber(), equalTo("77777"));
    assertThat(foundAccount.getBalance(), closeTo(50.0, 0.01));
  }



}