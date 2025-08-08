package app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.util.Optional;

public interface ProfitRepository extends JpaRepository<Profit, Long> {
  Optional<Profit> findByMonth(Month month);
}
