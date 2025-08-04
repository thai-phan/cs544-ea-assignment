package bank.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TraceRecord {

  @Id
  @GeneratedValue()
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dateTime;

  private long accountNumber;

  private String operation;

  private Double amount;

  public TraceRecord() {

  }

  public TraceRecord(Date dateTime, long accountNumber, String operation, Double amount) {
    this.dateTime = dateTime;
    this.accountNumber = accountNumber;
    this.operation = operation;
    this.amount = amount;
  }

  public String getOperation() {
    return operation;
  }

  public Double getAmount() {
    return amount;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }
}
