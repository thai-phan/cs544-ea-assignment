package domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
  protected String name;
  protected String description;
  protected double price;
  @Id
  @GeneratedValue
  private long id;

  public Product() {
  }

  public Product(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", id=" + id +
        '}';
  }
}
