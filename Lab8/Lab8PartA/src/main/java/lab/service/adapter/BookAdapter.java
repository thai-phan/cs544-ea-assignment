package lab.service.adapter;

import lab.domain.Book;
import lab.service.dto.BookDTO;

import java.util.List;

public class BookAdapter {

  public static Book convertDTOToBook(BookDTO bookDTO) {
    return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPrice());
  }

  public static BookDTO convertBookToDTO(Book book) {
    return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice());
  }

  public static List<BookDTO> convertBooksToDTOs(List<Book> books) {
    return books.stream()
        .map(BookAdapter::convertBookToDTO)
        .toList();
  }
}
