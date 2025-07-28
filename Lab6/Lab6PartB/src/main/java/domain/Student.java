package domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String studentNumber;

  @ManyToOne()
  @JoinColumn(name = "department_id")
  private Department department;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_id")
  private List<Grade> grades = new ArrayList<>();


  protected Student() {
  }

  public Student(String name, String studentNumber, Department department) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.department = department;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", studentNumber='" + studentNumber + '\'' +
        ", department=" + department +
        ", grades=" + grades +
        '}';
  }
}
