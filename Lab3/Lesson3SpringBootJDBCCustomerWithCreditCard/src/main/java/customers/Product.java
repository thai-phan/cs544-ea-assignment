package customers;

public class Product {
  private String productNumber;
  private String name;
  private Double price;
  private Supplier supplier;

  public Product(String productNumber, String name, Double price) {
    this.productNumber = productNumber;
    this.name = name;
    this.price = price;

  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setProductNumber(String productNumber) {
    this.productNumber = productNumber;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public String getProductNumber() {
    return productNumber;
  }

  @Override
  public String toString() {
    return "{Product name=" + name + ", productNumber= " + productNumber +
        " price= " + price + " supplier=" + supplier + "}";
  }
}
