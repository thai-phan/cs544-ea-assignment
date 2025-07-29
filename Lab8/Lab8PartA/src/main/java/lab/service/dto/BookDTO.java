package lab.service.dto;


public class BookDTO {

  private String isbn;
  private String title;
  private String author;
  private double price;


  public BookDTO(String isbn, String title, String author, double price) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }
}
