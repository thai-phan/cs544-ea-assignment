package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@NamedQuery(name = "Customer.getAllCustomersFrom", query = "select c from Customer c where c.address.country = :country")
public class Customer {
  private String firstname;
  private String lastname;

  @Id
  @GeneratedValue
  private long id;

  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "customer")
  private Collection<Order> orders = new ArrayList<>();

  @ManyToOne(cascade = {CascadeType.PERSIST})
  private Address address;

  public Customer() {

  }

  public Customer(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;

  }

  public void addOrder(Order order) {
    orders.add(order);
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Collection<Order> getTheOrders() {
    return orders;
  }

  public void setTheOrders(Collection<Order> theOrders) {
    this.orders = theOrders;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", id=" + id +
        '}';
  }
}
