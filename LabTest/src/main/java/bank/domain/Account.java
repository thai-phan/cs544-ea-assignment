package bank.domain;

import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "account")
public class Account {

  @Id
  long accountNumber;

  @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(name = "account_id")
  Collection<AccountEntry> entryList = new ArrayList<>();


  public Account(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  protected Account() {

  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountnumber) {
    this.accountNumber = accountnumber;
  }

  public double getBalance() {
    double balance = 0;
    for (AccountEntry entry : entryList) {
      balance += entry.getAmount();
    }
    return balance;
  }

  public void deposit(double amount) {
    AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "");
    entryList.add(entry);
  }

  public void withdraw(double amount) {
    AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "");
    entryList.add(entry);
  }

  private void addEntry(AccountEntry entry) {
    entryList.add(entry);
  }

  public void transferFunds(Account toAccount, double amount, String description) {
    AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountNumber());
    AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountNumber());
    entryList.add(fromEntry);
    toAccount.addEntry(toEntry);
  }

  public Collection<AccountEntry> getEntryList() {
    return entryList;
  }

}
