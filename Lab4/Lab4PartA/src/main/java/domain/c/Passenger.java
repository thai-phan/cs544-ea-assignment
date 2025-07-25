package domain.c;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;


  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "passenger_id")
  @OrderColumn(name = "flight_order")
  private List<Flight> flights = new ArrayList<>();

  public Passenger() {

  }

  public void addFlight(Flight flight) {
    flights.add(flight);
  }

  public Passenger(String name) {
    this.name = name;
  }
}
