package app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class School {

  @Id
  private long id;

  private String name;

  public School(String name) {

  }

  protected School() {

  }
}
