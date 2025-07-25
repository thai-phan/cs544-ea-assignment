package domain;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
  private String isbn;

  protected Book() {}

  public Book(String isbn) {
    this.isbn = isbn;
  }
}
