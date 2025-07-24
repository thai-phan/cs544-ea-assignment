package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  public void clearDB() {
    Map<String, Object> namedParameters = new HashMap<>();
    jdbcTemplate.update("DELETE from product", namedParameters);
    jdbcTemplate.update("DELETE from supplier", namedParameters);
  }

  public void save(Product product) {
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("product_number", product.getProductNumber());
    parameters.put("name", product.getName());
    parameters.put("price", product.getPrice());
    jdbcTemplate.update("INSERT INTO product VALUES (:product_number, :name, :price)", parameters);


    Map<String, Object> supplierParameters = new HashMap<>();
    supplierParameters.put("name", product.getSupplier().getName());
    supplierParameters.put("phone", product.getSupplier().getPhone());
    supplierParameters.put("product_number", product.getProductNumber());
    jdbcTemplate.update("INSERT INTO supplier VALUES (:name, :phone, :product_number)", supplierParameters);
  }


  // findByProductNumber() Return the product with this productNumber
  public Product findByProductNumber(String pNumber) {
    Map<String, Object> namedParameters = new HashMap<>();
    namedParameters.put("product_number", pNumber);
    Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_number = :product_number",
        namedParameters,
        (rs, rowNum) -> new Product(rs.getString("product_number"), rs.getString("name"), rs.getDouble("price")));

    return product;
  }


  // getAllProducts() Return the list with all products
  public List<Product> getAllProducts() {
    List<Product> products = jdbcTemplate.query("SELECT * FROM product",
        new HashMap<String, Product>(),
        (rs, rowNum) -> new Product(rs.getString("product_number"), rs.getString("name"), rs.getDouble("price")));

    for (Product p : products) {
      Supplier supplier = getSupplierForProduct(p.getProductNumber());
      p.setSupplier(supplier);
    }
    return products;
  }


  public Supplier getSupplierForProduct(String pNumber) {
    Map<String, Object> namedParameters = new HashMap<>();
    namedParameters.put("product_number", pNumber);
    Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE product_number = :product_number",
        namedParameters,
        (rs, rowNum) -> new Supplier(rs.getString("name"), rs.getString("phone")));

    return supplier;
  }

  // findByProductName() Return the list with products with this name
  public List<Product> findByProductName(String name) {
    Map<String, Object> namedParameters = new HashMap<>();
    namedParameters.put("name", name);
    List<Product> products = jdbcTemplate.query("SELECT * FROM product WHERE name = :name",
        namedParameters,
        (rs, rowNum) -> new Product(rs.getString("product_number"), rs.getString("name"), rs.getDouble("price")));
    return products;
  }

  // removeProduct Remove the product with the given productNumber
  public void removeProduct(String productNumber) {
    Map<String, Object> namedParameters = new HashMap<>();
    namedParameters.put("product_number", productNumber);
    jdbcTemplate.update("DELETE from product where product_number = :product_number", namedParameters);
  }
}
