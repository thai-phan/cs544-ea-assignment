package bank.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account_entry")
public class AccountEntry {
	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "entry_date")
	private Date date;

	@Column(name = "entry_amount")
	private double amount;

	@Column(name = "entry_description")
	private String description;

	private String fromAccountNumber;

	protected AccountEntry() {
	}

	public AccountEntry(Date date, double amount, String description, String fromAccountNumber) {
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}


}
