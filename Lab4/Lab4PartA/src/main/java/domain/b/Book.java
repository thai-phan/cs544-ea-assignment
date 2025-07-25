package domain.b;

import javax.persistence.*;

@Entity
public class Book {

  @Id
  private String isbn;

  private String title;

  private String author;

  @ManyToOne(optional = false)
  @JoinColumn(name = "publisher_id", nullable = false)
  private Publisher publisher;

  protected Book() {
  }

  public Book(String isbn, String title, String author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return "{Book: " + title + " isbn: " + isbn + "}";
  }
}
