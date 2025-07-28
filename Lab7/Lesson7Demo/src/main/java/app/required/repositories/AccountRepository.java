package app.required.repositories;


import app.required.domain.AccountR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountR, Long> {
}
