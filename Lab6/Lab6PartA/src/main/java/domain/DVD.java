package domain;

import jakarta.persistence.*;

@Entity
public class DVD extends Product {
  private String genre;

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "DVD{" +
        "genre='" + genre + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        '}';
  }
}
