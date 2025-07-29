package lab.controller;


import lab.service.IBookService;
import lab.service.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private IBookService bookService;

  @PostMapping()
  public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
    try {
      BookDTO createdBookDTO = bookService.addBook(bookDTO);
      return ResponseEntity.ok(createdBookDTO);
    } catch (Exception exception) {
      System.out.println("exception = " + exception.getMessage());
      return new ResponseEntity<>(new CalculationError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping
  public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
    BookDTO updatedBookDTO = bookService.updateBook(bookDTO);
    return ResponseEntity.ok(updatedBookDTO);
  }

  @DeleteMapping("/{isbn}")
  public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
    bookService.deleteBook(isbn);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{isbn}")
  public ResponseEntity<BookDTO> getBook(@PathVariable String isbn) {
    BookDTO bookDTO = bookService.getBook(isbn);
    return ResponseEntity.ok(bookDTO);
  }

  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBooks() {
    List<BookDTO> bookDTOS = bookService.getAllBooks();
    return ResponseEntity.ok(bookDTOS);
  }

  @GetMapping("/search")
  public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam String author) {
    List<BookDTO> bookDTOS = bookService.searchBooksByAuthor(author);
    return ResponseEntity.ok(bookDTOS);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleExceptions(Exception exception) {
    Map<String, Object> map = new HashMap<>();
    map.put("isSuccess", false);
    map.put("error", exception.getMessage());
    map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
