package bank.domain;

import jakarta.persistence.*;

import java.util.Date;

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

  public Flight(String flightNumber, String from, String to, Date date) {
    this.flightNumber = flightNumber;
    this.date = date;
    this.from = from;
    this.to = to;
  }

  @Temporal(TemporalType.DATE)
  private Date date;

}
