package repositories;

import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecifications {
    public static Specification<Order> isClosed() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), "closed");
    }
}

