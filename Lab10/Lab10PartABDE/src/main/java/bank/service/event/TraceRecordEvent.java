package bank.service.event;


import java.util.Date;

public class TraceRecordEvent {
  private Date dateTime;

  private long accountNumber;

  private String operation;

  private Double amount;

  protected TraceRecordEvent() {

  }

  public TraceRecordEvent(Date dateTime, long accountNumber, String operation, Double amount) {
    this.dateTime = dateTime;
    this.accountNumber = accountNumber;
    this.operation = operation;
    this.amount = amount;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public Double getAmount() {
    return amount;
  }

  public String getOperation() {
    return operation;
  }

  public long getAccountNumber() {
    return accountNumber;
  }
}
