package bank.service.dto;


import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.Collection;


public class AccountDTO {

  long accountNumber;

  Collection<AccountEntry> entryList = new ArrayList<>();

  CustomerDTO customerDTO;

  double balance;

  public AccountDTO(long accountnr) {
    this.accountNumber = accountnr;
  }


  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public CustomerDTO getCustomerDTO() {
    return customerDTO;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public Collection<AccountEntry> getEntryList() {
    return entryList;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setCustomerDTO(CustomerDTO customerDTO) {
    this.customerDTO = customerDTO;
  }

  public void setEntryList(Collection<AccountEntry> entryList) {
    this.entryList = entryList;
  }

  @Override
  public String toString() {
    return "AccountDTO{" +
            "accountNumber=" + accountNumber +
            ", entryList=" + entryList +
            ", customerDTO=" + customerDTO +
            ", balance=" + balance +
            '}';
  }
}
