package app;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "school_id")
  private List<Student> students = new ArrayList<>();

  public School(String name) {
    this.name = name;
  }

  protected School() {

  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  @Override
  public String toString() {
    return "School{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", students=" + students +
        '}';
  }
}
