package domain;

import jakarta.persistence.*;

@Entity
public class Grade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String grade;

  @ManyToOne()
  @JoinColumn(name = "course_id")
  private Course course;

  protected Grade() {
  }

  public Grade(String grade, Course course) {
    this.grade = grade;
    this.course = course;
  }

  @Override
  public String toString() {
    return "Grade{" +
        "grade='" + grade + '\'' +
        ", course=" + course +
        '}';
  }
}

