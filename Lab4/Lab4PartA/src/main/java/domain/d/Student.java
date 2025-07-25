package domain.d;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

  @Id
  private Long studentid;

  private String firstname;
  private String lastname;

  public Student() {}
  public Student(Long studentid, String firstname, String lastname) {
    this.studentid = studentid;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public Long getStudentid() {
    return studentid;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public void setStudentid(Long studentid) {
    this.studentid = studentid;
  }
}
