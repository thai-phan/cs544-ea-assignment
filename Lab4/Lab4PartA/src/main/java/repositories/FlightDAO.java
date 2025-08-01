package repositories;

import domain.c.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDAO extends JpaRepository<Flight, Long> {


}
