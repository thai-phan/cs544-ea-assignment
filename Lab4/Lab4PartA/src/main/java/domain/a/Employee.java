package domain.a;

import javax.persistence.*;


@Entity
public class Employee {

  @Id
  @GeneratedValue
  private Integer employeeNumber;

  private String name;


  @ManyToOne()
  @JoinColumn(name = "department_id")
  private Department department;

  protected Employee() {
  }

  public Employee(String name, String role) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Department getDepartment() {
    return department;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "{Employee: " + name + "}";
  }
}
