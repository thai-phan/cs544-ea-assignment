package bank.message;


public class AccountCreation {
  private long accountNumber;
  private String customerName;

  public AccountCreation() {
  }

  public AccountCreation(long accountNumber, String customerName) {
    this.customerName = customerName;
    this.accountNumber = accountNumber;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerName() {
    return customerName;
  }
}

