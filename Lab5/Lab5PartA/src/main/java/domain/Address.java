package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
  @Id
  @GeneratedValue
  private Integer id;

  private String street;
  private String city;
  private String zip;

  public Address(String street, String city, String zip) {
    super();
    this.street = street;
    this.city = city;
    this.zip = zip;
  }

  public Address() {

  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

}
