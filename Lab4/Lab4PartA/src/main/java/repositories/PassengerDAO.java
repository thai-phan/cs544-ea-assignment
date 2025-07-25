package repositories;

import domain.c.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger, Long> {


}
