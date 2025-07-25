package domain;


import javax.persistence.*;


@Entity
public class OrderLine {
  @Id
  @GeneratedValue
  private Long id;

  private int quantity;


  @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Product product;


  public OrderLine() {

  }

  public OrderLine(int quantity, Product product) {
    this.quantity = quantity;
    this.product = product;
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

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
