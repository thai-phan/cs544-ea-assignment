package domain;

import jakarta.persistence.*;

@Entity
public class Book extends Product {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        '}';
  }
}
