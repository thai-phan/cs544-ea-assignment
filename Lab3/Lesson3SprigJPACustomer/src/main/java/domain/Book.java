package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue
  private int id;
  private String title;
  private String ISBN;
  private String author;
  private double price;

  protected Book() {

  }

  public Book(String title, String ISBN, String author, double price) {
    this.title = title;
    this.ISBN = ISBN;
    this.author = author;
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("Book[id=%d, title=%s, ISBN=%s, author=%s, price=%f]", id,  title, ISBN, author, price);
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public String getAuthor() {
    return author;
  }

  public String getISBN() {
    return ISBN;
  }

  public String getTitle() {
    return title;
  }
}