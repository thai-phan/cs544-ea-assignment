package app.requiresnew.repositories;

import app.requiresnew.domain.CustomerRN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerRN, Long> {

}
