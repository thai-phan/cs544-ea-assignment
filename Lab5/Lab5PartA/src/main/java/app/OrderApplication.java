package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.OrderDAO;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner {

  @Autowired
  private OrderDAO orderDAO;

  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    DVD dvd = new DVD("Scifi");
    dvd.setName("The Matrix");
    dvd.setDescription("Movie!!");
    dvd.setPrice(35.50);
    OrderLine ol1 = new OrderLine(2, dvd);

    Book book = new Book("ISBN-1234567890");
    book.setName("Hibernate in Action");
    book.setDescription("Album from 1995");
    book.setPrice(12.98);
    OrderLine ol2 = new OrderLine(4, book);

    CD cd = new CD("Queen");
    cd.setName("The best of Queen");
    cd.setDescription("Album from 1995");
    cd.setPrice(12.98);
    OrderLine ol3 = new OrderLine(4, cd);

    Order o1 = new Order("234743", "12/10/06", "open");
    o1.addOrderLine(ol1);
    o1.addOrderLine(ol2);
    o1.addOrderLine(ol3);

    Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1", "New york", "43221");
    c1.addOrder(o1);
    o1.setCustomer(c1);

    orderDAO.save(o1);

    Order order = orderDAO.getOrderById(1L);

    printOrder(order);
  }

  public static void printOrder(Order order) {
    System.out.println("Order with orderNumber: " + order.getOrderNumber());
    System.out.println("Order date: " + order.getDate());
    System.out.println("Order status: " + order.getStatus());
    Customer cust = order.getCustomer();
    System.out.println("Customer: " + cust.getFirstname() + " "
        + cust.getLastname());
    for (OrderLine orderline : order.getOrderlines()) {
      System.out.println("Order line: quantity= "
          + orderline.getQuantity());
      Product product = orderline.getProduct();
      System.out.println("Product: " + product.getName() + " "
          + product.getDescription() + " " + product.getPrice());
    }

  }
}
