package lab.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

  @Id
  private String isbn;
  private String title;
  private String author;
  private double price;


  public Book(String isbn, String title, String author, double price) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  public Book() {

  }

  public String getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }
}
