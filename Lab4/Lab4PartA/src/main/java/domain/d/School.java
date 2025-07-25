package domain.d;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "school_id")
  @MapKey(name = "studentid")
  private Map<Long, Student> students = new HashMap<>();

  public School() {
  }

  public School(String name) {
    this.name = name;
  }

  public void addStudent(Student student) {
    students.put(student.getStudentid(), student);
  }

  public void setName(String name) {
    this.name = name;
  }

}
