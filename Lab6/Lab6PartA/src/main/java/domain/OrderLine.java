package domain;

import jakarta.persistence.*;

@Entity
public class OrderLine {
  private int quantity;
  @Id
  @GeneratedValue
  private long id;
  @ManyToOne(cascade = {CascadeType.PERSIST})
  private Product product;

  public OrderLine() {
  }

  public OrderLine(int quantity) {
    this.quantity = quantity;
  }

  public OrderLine(int quantity, Product product) {
    this.quantity = quantity;
    this.product = product;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}
