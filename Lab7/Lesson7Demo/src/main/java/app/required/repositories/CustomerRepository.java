package app.required.repositories;

import app.required.domain.CustomerR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerR, Long> {

}
