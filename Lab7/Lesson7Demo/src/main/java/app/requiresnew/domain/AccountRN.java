package app.requiresnew.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AccountRN {
    @Id
    @GeneratedValue
    private long id;
    private int accountNumber;
    private String accountType;

    public AccountRN() {
    }

    public AccountRN(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
