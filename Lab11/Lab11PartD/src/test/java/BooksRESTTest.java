import books.web.Books;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BooksRESTTest {

  @BeforeClass
  public static void setup() {
    RestAssured.port = Integer.valueOf(8080);
    RestAssured.baseURI = "http://localhost";
    RestAssured.basePath = "";
  }

  @Test
  public void testGetOneBook() {
    // add the book to be fetched
    Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
    given()
        .contentType("application/json")
        .body(book)
        .when().post("/books").then()
        .statusCode(200);
    // test getting the book
    given()
        .when()
        .get("books/878")
        .then()
        .contentType(ContentType.JSON)
        .and()
        .body("isbn", equalTo("878"))
        .body("title", equalTo("Book 123"))
        .body("price", equalTo(18.95f))
        .body("author", equalTo("Joe Smith"));
    //cleanup
    given()
        .when()
        .delete("books/878");
  }

  @Test
  public void testPostOneBook() {
    // add the book to be fetched
    Book book = new Book("467", "Book 467", 22.95, "Mary Jones");
    given()
        .contentType("application/json")
        .body(book)
        .when()
        .post("/books")
        .then()
        .contentType(ContentType.JSON)
        .body("isbn", equalTo("467"))
        .body("title", equalTo("Book 467"))
        .body("price", equalTo(22.95F))
        .body("author", equalTo("Mary Jones"))
        .statusCode(200);

    //cleanup
    given()
        .when()
        .delete("books/467");
  }

  @Test
  public void testGetAllBooks() {
    // add the book to be fetched
    Book book1 = new Book("111", "Book 111", 11.95, "Joe Smith");
    Book book2 = new Book("222", "Book 222", 22.95, "Mary Jones");
    Book book3 = new Book("333", "Book 333", 33.95, "Mike Johnson");
    List<Book> books = Arrays.asList(book1, book2, book3);
    for (Book b : books) {
      given()
          .contentType("application/json")
          .body(b)
          .when()
          .post("/books")
          .then()
          .statusCode(200);
    }

    // test getting all books
    Books allbooks = given()
        .when()
        .get("books").as(Books.class);

    System.out.println(allbooks);
    // assertions
    assert allbooks.getBooks().size() >= 3;
    assert allbooks.getBooks().stream().filter(b -> b.getIsbn().equals("111")).findFirst().get().getAuthor().equals("Joe Smith");
    assert allbooks.getBooks().stream().filter(b -> b.getIsbn().equals("222")).findFirst().get().getAuthor().equals("Mary Jones");
    assert allbooks.getBooks().stream().filter(b -> b.getIsbn().equals("333")).findFirst().get().getAuthor().equals("Mike Johnson");

    //cleanup
    for (Book b : books) {
      given()
          .when()
          .delete("books/" + b.getIsbn());
    }
  }

  @Test
  public void testSearchBooksByAuthor() {
    // add the book to be searched
    Book book = new Book("123", "Book 123", 18.95, "Joe Smith");
    given()
        .contentType("application/json")
        .body(book)
        .when()
        .post("/books")
        .then()
        .statusCode(200);

    // test searching by author
    Books books = given()
        .when()
        .get("books?author=Joe Smith").as(Books.class);

    assert books.getBooks().size() == 1;
    assert books.getBooks().stream().filter(b -> b.getIsbn().equals("123")).findFirst().get().getAuthor().equals("Joe Smith");

    System.out.println(books);
  }


}
