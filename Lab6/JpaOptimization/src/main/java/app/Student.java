package app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

  @Id
  @GeneratedValue
  private long id;

  private String firstName;
  private String lastName;
  private String emailAddress;

  public Student(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  protected Student() {

  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
