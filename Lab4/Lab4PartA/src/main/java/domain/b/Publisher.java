package domain.b;


import javax.persistence.*;


@Entity
public class Publisher {


  @Id
  @GeneratedValue
  private Integer id;

  private String name;


  protected Publisher() {

  }

  public Publisher(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "{Publisher: " + name + "}";
  }


}
