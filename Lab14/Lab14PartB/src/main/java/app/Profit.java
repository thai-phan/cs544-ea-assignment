package app;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Month;

@Entity
public class Profit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private Month month;

  private BigDecimal amount;

  public Profit() {}

  public Profit(Long id, Month month, BigDecimal amount) {
    this.id = id;
    this.month = month;
    this.amount = amount;
  }

  public Long getId() { return id; }
  public Month getMonth() { return month; }
  public BigDecimal getAmount() { return amount; }

  public void setId(Long id) { this.id = id; }
  public void setMonth(Month month) { this.month = month; }
  public void setAmount(BigDecimal amount) { this.amount = amount; }
}
