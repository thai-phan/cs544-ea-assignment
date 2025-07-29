package lab.service;



import lab.service.dto.BookDTO;

import java.util.List;

public interface IBookService {
  BookDTO addBook(BookDTO book);
  BookDTO updateBook(BookDTO book);
  void deleteBook(String isbn);
  BookDTO getBook(String isbn);
  List<BookDTO> getAllBooks();
  List<BookDTO> searchBooksByAuthor(String author);
}
