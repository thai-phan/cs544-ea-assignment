package app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfitRepository extends JpaRepository<Profit, Long> {
  Profit getProfitByMonth(String month);
}
