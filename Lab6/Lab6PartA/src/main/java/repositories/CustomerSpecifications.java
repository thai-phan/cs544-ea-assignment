package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {
    public static Specification<Customer> isFromCity(String city) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("address").get("city"), city);
    }
}

