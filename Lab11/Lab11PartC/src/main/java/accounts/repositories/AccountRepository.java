package accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;


public interface AccountRepository extends JpaRepository<Account, String> {
  Account findByAccountHolder(String accountHolder);
}
