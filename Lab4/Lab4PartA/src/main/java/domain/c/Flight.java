package domain.c;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Flight {

  @Id
  @GeneratedValue
  private Integer id;

  private String flightNumber;

  @Column(name = "from_location")
  private String from;

  @Column(name = "to_location")
  private String to;

  public Flight() {
  }

  public Flight(String from, String to, LocalDate date) {
    this.date = date;
    this.from = from;
    this.to = to;
  }

  private LocalDate date;

}
