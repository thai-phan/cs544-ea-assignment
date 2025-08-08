package app;

import java.math.BigDecimal;

public class ProfitRecord {
  private Long id;
  private String month;
  private BigDecimal amount;

  public ProfitRecord() {}

  public Long getId() { return id; }
  public String getMonth() { return month; }
  public BigDecimal getAmount() { return amount; }

  public void setId(Long id) { this.id = id; }
  public void setMonth(String month) { this.month = month; }
  public void setAmount(BigDecimal amount) { this.amount = amount; }
}
