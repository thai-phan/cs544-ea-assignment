package app.required.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Customer {
  @Id
  @GeneratedValue
  private long id;
  private String name;


  public Customer() {

  }

  public Customer(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
