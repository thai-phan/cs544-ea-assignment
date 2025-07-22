package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ProductDAO implements IProductDAO {

  @Autowired
  private ILogger logger;

  public void save(Product product) {
    // simple sleep
    try {
      Thread.sleep(350);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("ProductDAO: saving product " + product.getName());
    logger.log("Product is saved in the DB: " + product.getName());
  }

}
