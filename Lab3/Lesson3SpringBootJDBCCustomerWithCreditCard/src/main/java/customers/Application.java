package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private CustomerDAO customerDao;

  @Autowired
  private ProductDAO productDAO;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    customerDao.clearDB();
    Customer customer = new Customer(101, "John doe", "johnd@acme.com", "0622341678");
    CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
    customer.setCreditCard(creditCard);
    customerDao.save(customer);
    customer = new Customer(66, "James Johnson", "jj123@acme.com", "068633452");
    creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
    customer.setCreditCard(creditCard);
    customerDao.save(customer);
    System.out.println(customerDao.getCustomer(101));
    System.out.println(customerDao.getCustomer(66));
    System.out.println("-----------All customers ----------------");
    System.out.println(customerDao.getAllCustomers());

    productDAO.clearDB();
    Product product = new Product("101", "Book 1", 10.0);
    Supplier supplier = new Supplier("Supplier 1", "0987363234");
    product.setSupplier(supplier);
    productDAO.save(product);

    product = new Product("222", "Book 3", 15.0);
    supplier = new Supplier("Supplier 3", "123242311332");
    product.setSupplier(supplier);
    productDAO.save(product);

    product = new Product("66", "Book 2", 20.0);
    supplier = new Supplier("Supplier 2", "023234234234");
    product.setSupplier(supplier);
    productDAO.save(product);

    productDAO.removeProduct("101");
    System.out.println(productDAO.findByProductName("Book 3"));
    System.out.println(productDAO.getSupplierForProduct("66"));
    System.out.println("-----------All products ----------------");
    System.out.println(productDAO.getAllProducts());

  }
}
