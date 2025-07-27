package repositories;

import domain.CD;
import domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CDSpecifications {
    public static Specification<CD> isFromArtist(String artist) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("artist"), artist);
    }

    public static Specification<CD> withPriceLargerThan(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), price);
    }

}

