package domain;


import jakarta.persistence.*;

@Entity
@SecondaryTables(@SecondaryTable(
    name = "address",
    pkJoinColumns = {
        @PrimaryKeyJoinColumn(
            name = "patient_id",
            referencedColumnName = "id"
        )
    })
)
public class Patient {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Column(table = "address")
  private String street;

  @Column(table = "address")
  private String zip;

  @Column(table = "address")
  private String city;


  public Patient() {

  }

  public Patient(String name, String street, String zip, String city) {
    this.name = name;
    this.street = street;
    this.zip = zip;
    this.city = city;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
