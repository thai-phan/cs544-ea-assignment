package app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Profit {
    @Id
    @GeneratedValue
    private Long id;
    private String month;
    private Double amount;

    public Profit() {
    }

    public Profit(String month, Double amount) {

        this.month = month;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                '}';
    }
}
