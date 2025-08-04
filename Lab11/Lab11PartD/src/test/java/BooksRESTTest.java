import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

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
        .body("price", equalTo(22.95))
        .body("author", equalTo("Mary Jones"))
        .statusCode(200);

    //cleanup
    given()
        .when()
        .delete("books/467");
  }




}
