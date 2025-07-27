package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "order_table")
public class Order {
  private String orderNumber;
  private String date;
  private String status;
  @Id
  @GeneratedValue
  private long id;
  @ManyToOne(cascade = {CascadeType.PERSIST})
  private Customer customer;

  @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
  private Collection<OrderLine> orderLines = new ArrayList<>();

  public Order() {
  }

  public Order(String orderNumber, String date, String status) {
    this.orderNumber = orderNumber;
    this.date = date;
    this.status = status;
  }

  public void addOrderLine(OrderLine ol) {
    orderLines.add(ol);
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Collection<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(Collection<OrderLine> orderlines) {
    this.orderLines = orderlines;
  }
}
