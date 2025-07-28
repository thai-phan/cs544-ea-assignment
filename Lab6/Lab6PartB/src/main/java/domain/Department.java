package domain;

import jakarta.persistence.*;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  protected Department() {
  }

  public Department(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Department{" +
        "name='" + name + '\'' +
        '}';
  }
}

