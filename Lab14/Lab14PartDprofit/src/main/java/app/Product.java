package app;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(length = 2000)
  private String description;

  private BigDecimal price;

  private Integer stock;

  private Double rating;

  public Product() {}

  public Product(Long id, String name, String description, BigDecimal price, Integer stock, Double rating) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.rating = rating;
  }


  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }

  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }

  public Double getRating() { return rating; }
  public void setRating(Double rating) { this.rating = rating; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product p = (Product) o;
    return Objects.equals(id, p.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
