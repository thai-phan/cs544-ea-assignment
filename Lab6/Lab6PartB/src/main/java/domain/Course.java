package domain;

import jakarta.persistence.*;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Course(String name) {
    this.name = name;
  }

  protected Course() {
  }

  @Override
  public String toString() {
    return "Course{" +
        "name='" + name + '\'' +
        '}';
  }
}
