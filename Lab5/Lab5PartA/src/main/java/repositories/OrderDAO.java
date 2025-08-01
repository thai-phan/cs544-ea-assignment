package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {

  Order getOrderById(Long id);
}
