package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "customer_order")
public class Order {
  @Id
  @GeneratedValue
  private Long id;

  private String orderNumber;
  private String date;
  private String status;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;


  @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  private Collection<OrderLine> orderlines = new ArrayList<>();


  public Order() {
  }

  public Order(String orderNumber, String date, String status) {
    this.orderNumber = orderNumber;
    this.date = date;
    this.status = status;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String ordernr) {
    this.orderNumber = ordernr;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
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

  public Collection<OrderLine> getOrderlines() {
    return Collections.unmodifiableCollection(orderlines);
  }

  public boolean addOrderLine(OrderLine ol) {
    return orderlines.add(ol);
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
