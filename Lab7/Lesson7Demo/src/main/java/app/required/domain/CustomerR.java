package app.required.domain;

import jakarta.persistence.*;


@Entity
public class CustomerR {
  @Id
  @GeneratedValue
  private long id;
  private String name;


  public CustomerR() {

  }

  public CustomerR(String name) {
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
