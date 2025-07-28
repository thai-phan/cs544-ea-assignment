package app.requiresnew.repositories;


import app.requiresnew.domain.AccountRN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountRN, Long> {
}
