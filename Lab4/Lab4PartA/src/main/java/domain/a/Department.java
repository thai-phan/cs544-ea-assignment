package domain.a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//  Create a Bidirectional OneToMany association between Department and Employee.
//  So in this case you save the Department in the database and make sure the
//  corresponding Employee is also saved at the same time.
//  Then you retrieve the Department from the database and check if the Employee is also
//  automatically retrieved.

@Entity
public class Department {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;


  @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Employee> employees = new ArrayList<>();

  protected Department() {

  }

  public Department(String name) {
    this.name = name;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.setDepartment(this);
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "{Department: " + name + " employees: " + employees + "}";
  }
}
