package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements IProductService {

  @Autowired
  private IProductDAO productDAO;

  @Autowired
  private IEmailSender emailSender;

  public void addProduct(String name, Double price, String email) {
    Product product = new Product(name, price);
    productDAO.save(product);
    emailSender.sendEmail(email, "Created " + name + " as a new product");
  }
}
