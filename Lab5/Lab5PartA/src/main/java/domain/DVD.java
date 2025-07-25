package domain;


import javax.persistence.Entity;

@Entity
public class DVD extends Product {
  private String genre;

  public DVD(String genre) {
    this.genre = genre;
  }

  protected DVD() {

  }
}
